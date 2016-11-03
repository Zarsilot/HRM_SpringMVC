package com.icss.system;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * 
 * 2016-09-13
 */
public class SerializeUtil implements Serializable {
	//序列化
	public static byte[] serialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		
		try {
			try {
				//程序内部创建一个byte型数组的缓冲区，把所有的变量收集到一起；可以捕获内存缓冲区的数据，转换成字节数组
				baos = new ByteArrayOutputStream();
				byte[] bytes = baos.toByteArray();
				oos = new ObjectOutputStream(baos);
				//将对象obj写入流
				oos.writeObject(obj);
				
				return bytes;
			} finally {
				oos.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//反序列化
	public static Object unserialize(byte[] bytes){
		if(bytes == null)
			return null;
		
		ByteArrayInputStream bais = null;
		try {
			//将字节数组转换为输入流
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object obj = ois.readObject();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
