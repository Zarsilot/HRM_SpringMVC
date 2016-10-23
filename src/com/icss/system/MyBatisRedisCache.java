package com.icss.system;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/*
 * 
 * 2016-09-13,使用redis作为mybatis的二级缓存
 * 2016-09-14,改进内部类CachePool,实现内部类PropertiesLoader
 */
public class MyBatisRedisCache implements Cache {

//	@Value("#{redisConfig['redis.ip']}")
//	protected String redisIp;
//	@Value("#{redisConfig['redis.port']}")
//	protected Integer redisPort;

	private static final Logger LOG = Logger.getLogger(MyBatisRedisCache.class);
	// private static Log logger = LogFactory.getLog(MyBatisRedisCache.class);

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

	// 必须实现
	public String id;

	public MyBatisRedisCache() {
		super();
	}

	// 必须实现该构造函数
	public MyBatisRedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("缓存没有初始化ID");
		}
		LOG.info("Redis Cache id " + id);
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void putObject(Object key, Object value) {
		LOG.debug("=====putObject:" + key + "=" + value);
		Jedis jedis = null;
		JedisPool jedisPool = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			jedis.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			if (borrowOrOprSuccess)
				jedisPool.returnResource(jedis);
		}
	}

	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			value = SerializeUtil.unserialize(jedis.get(SerializeUtil.serialize(key.toString())));
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			if (borrowOrOprSuccess)
				jedisPool.returnResource(jedis);
		}
		LOG.debug("=====getObject:" + key + "=" + value);
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			value = jedis.expire(SerializeUtil.serialize(key.toString()), 0);
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				//close()方法替换returnBrokenResource()方法
				jedisPool.close();
		} finally {
			if (borrowOrOprSuccess)
//				jedisPool.
				jedisPool.returnResource(jedis);
		}
		return value;
	}

	@Override
	public void clear() {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			jedis.flushDB();
			jedis.flushAll();
		} catch (JedisConnectionException e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedisPool.returnBrokenResource(jedis);
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
				jedisPool.returnResource(jedis);
		}
	}

	@Override
	public int getSize() {
		Jedis jedis = null;
		JedisPool jedisPool = null;
		int result = 0;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = CachePool.getInstance().getJedis();
			jedisPool = CachePool.getInstance().getJedisPool();
			result = Integer.valueOf(jedis.dbSize().toString());
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
		} finally {
			if (borrowOrOprSuccess) {
				jedisPool.returnResource(jedis);
			}
		}
		return result;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return readWriteLock;
	}

	/*
	 * 
	 * 单例Cache池
	 */
	public static class CachePool {
		JedisPool pool;
		private static final CachePool cachePool = new CachePool();

		private CachePool() {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(100);
			config.setMaxTotal(500);
			config.setMaxWaitMillis(1000l);
			config.setTestOnBorrow(true);

			PropertiesLoader pl = new PropertiesLoader("redis.properties");
			pool = new JedisPool(config, pl.getProperty("redis.ip"));
		}

		public static CachePool getInstance() {
			return cachePool;
		}

		public Jedis getJedis() {
			Jedis jedis = null;
			boolean borrowOrOprSuccess = true;
			try {
				jedis = pool.getResource();
			} catch (JedisConnectionException e) {
				// 释放redis对象
				borrowOrOprSuccess = false;
				if (jedis != null)
					jedis.disconnect();
					pool.returnBrokenResource(jedis);
			} finally {
				// 返还到连接池
				if (borrowOrOprSuccess)
					pool.returnResource(jedis);
			}
			return jedis;
		}

		public JedisPool getJedisPool() {
			return this.pool;
		}

	}
	
	/*
	 * 加载属性文件
	 * 读取属性文件的六种方式：
	 * 1、java.util.Properties的load()方法
	 * 2、java.util.ResourceBundle类的getBundle()方法
	 * 3、java.util.PropertyResourceBundle类的构造函数
	 * 4、使用class变量的getResourceAsStream()方法
	 * 5、使用class.getClassLoader()所得到的java.lang.ClassLoader的getResourceAsStream()方法
	 * 6、使用java.lang.ClassLoader类的getSystemResouurceAsStream()静态方法
	 */
	public static class PropertiesLoader{
		private String fileName;
		Properties prop;
		InputStream in;

		public PropertiesLoader(String fileName) {
			super();
			prop = new Properties();
			in = null;
			
			try {
				in = ClassLoader.getSystemResourceAsStream(fileName);
				prop.load(in);
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally{
				try {
					if(null != in){
						in.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		public String getProperty(String key){
			Enumeration en = prop.propertyNames();
			String value = prop.get(key).toString();
			return value;
		}
		
	}

}
