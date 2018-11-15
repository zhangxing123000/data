package com.zhangxing.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zhangxing.eshop.model.User;
import com.zhangxing.eshop.service.UserService;

/**
 * 用户controller
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("getUserInfo")
	@ResponseBody
	public User getUserInfo(){
		return userService.findUserInfo();
	}
	
	public static void main(String[] args) {
		String json = "[{\"name\": \"lisi\", \"age\":28},{\"name\": \"lisi1\", \"age\":28}]";
		JSONObject userJSONObject = JSONObject.parseObject(json);
		System.out.println(userJSONObject.size());
		User user = new User();
		user.setName(userJSONObject.getString("name"));   
		user.setAge(userJSONObject.getInteger("age"));  
		System.err.println(user.toString());
	}
}
