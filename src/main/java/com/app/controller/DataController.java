package com.app.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.SpringBootUserDAO;
import com.app.dao.UserRoleDAO;
import com.app.model.SpringBootUser;
import com.app.model.UserRole;

@RestController
@RequestMapping(value="/json")
public class DataController {
	private static final Logger logger = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	SpringBootUserDAO dao;
	@Autowired
	UserRoleDAO roleDao;
	
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "/getUserInfo" ,produces="application/json" , method = RequestMethod.POST)
	public Map<String,String> getUserInfo(HttpSession session) {
		Map<String,String> map = new HashMap<>();
		logger.info("Get User Info Sucess! Login user is [{}]!",(String)session.getAttribute("loginUser"));
		map.put("loginUser",(String)session.getAttribute("loginUser"));
		return map;
	}
	
	@RequestMapping(value = "/singup" , method = RequestMethod.POST)
	public String singUp(@RequestBody Map<String,String> map) {
		String userId = map.get("userId");
		String userName = map.get("userName");
		String pwd = bCryptPasswordEncoder.encode(map.get("userPwd"));
		
		SpringBootUser user = new SpringBootUser();
		UserRole role = new UserRole();
		
		user.setCreateDate(new Date());
		user.setUserId(userId);
		user.setUserPassword(pwd);
		user.setUserType(1);
		user.setUserName(userName);
		
		role.setUserId(userId);
		role.setRoleId(2);
		
		dao.save(user);
		roleDao.save(role);
		
		return "Sucess";
	}
}
