package com.icss.system;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

/*
 * 
 * 2016-09-13,使用redis作为mybatis的二级缓存
 */
public class MyBatisRedisCache implements Cache {
	
	@Value("#{redisConfig['redis.ip']}")
	protected String redisIp;
	@Value("#{redisConfig['redis.port']}")
	protected Integer redisPort;
	
	private static final Logger LOG = Logger.getLogger(MyBatisRedisCache.class);
//	private static Log logger = LogFactory.getLog(MyBatisRedisCache.class);
	
	private Jedis redisClient = createClient();
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

	//必须实现
	public String id;
	
	public MyBatisRedisCache() {
		super();
	}
	
	//必须实现该构造函数
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
		LOG.debug("=====putObject:"+ key + "=" + value);
		redisClient.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
	}

	@Override
	public Object getObject(Object key) {
		Object value = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key.toString())));
		LOG.debug("=====getObject:"+ key + "=" + value);
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
	}

	@Override
	public void clear() {
		redisClient.flushDB();
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
			result = Integer.valueOf(redisClient.dbSize().toString())
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if(jedis != null){
				jedisPool.returnBrokenResource(jedis);
			}
		}finally{
			if(borrowOrOprSuccess){
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
	
	//创建客户端对象
	private Jedis createClient(){
		try {
			RedisUtil.initRedis(redisIp);
			return RedisUtil.getRedis();
			
//			JedisPool pool = new JedisPool(new JedisPoolConfig(),"192.168.234.9");
//			return pool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		throw new RuntimeException("初始化Redis错误");
	}
	
	/*
	 * 
	 * 单例Cache池
	 */
	public static class CachePool{
		JedisPool pool;
		private static final CachePool cachePool= new CachePool();
		
		private CachePool(){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxIdle(100);
			config.setMaxWaitMillis(1000l);
			
			PropertiesLoader pl = new PropertyLoader("classpath:redis.properties");
			pool = new JedisPool(config, pl.getProperty("redis.ip"));
		}
		
		public static CachePool getInstance(){
			return cachePool;
		}
		
		public Jedis getJedis(){
			Jedis jedis = null;
			boolean borrowOrOprSuccess = true;
			try {
				jedis = pool.getResource();  
            } catch (JedisConnectionException e) {  
                    borrowOrOprSuccess = false;  
                    if (jedis != null)  
                            pool.returnBrokenResource(jedis);  
            } finally {  
                    if (borrowOrOprSuccess)  
                            pool.returnResource(jedis);  
            }  
            return jedis;  
		}
		
		public JedisPool getJedisPool(){
			return this.pool;
		}
		
	}

}
