package com.zhangxing.eshop.dao;

/**
 * redis的接口方法
 * 包含了基本的set get delete
 * @author zhangxing
 *
 */
public interface RedisDAO {

	void set(String key , String value);
	String get(String key);
	void delete(String key);
}
