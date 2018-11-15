package com.zhangxing.eshop.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhangxing.eshop.mapper.UserMapper;
import com.zhangxing.eshop.model.User;
import com.zhangxing.eshop.service.UserService;

/**
 * 用户service 实现类
 * @author zhangxing
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User findUserInfo() {
		return userMapper.findUserInfo();
	}
	
}
