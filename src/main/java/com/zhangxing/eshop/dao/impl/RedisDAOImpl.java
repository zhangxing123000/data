package com.zhangxing.eshop.dao.impl;

import com.zhangxing.eshop.dao.RedisDAO;

import redis.clients.jedis.JedisCluster;

/**
 * redis 实现类
 * @author zhangxing
 *
 */
public class RedisDAOImpl implements RedisDAO {

	private JedisCluster jedisCluster;
	@Override
	public void set(String key, String value) {
		jedisCluster.set(key, value);
	}

	@Override
	public String get(String key) {
		return jedisCluster.get(key);
	}

	@Override
	public void delete(String key) {
		jedisCluster.del(key);
	}

}
