package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.SpringBootUserDAO;
import com.app.dao.UserRoleDAO;
import com.app.model.SpringBootUser;

@Controller
public class ViewController {
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	@Autowired
	SpringBootUserDAO dao;
	@Autowired
	UserRoleDAO roleDao;
	
	@RequestMapping(value={"/","/login"})
    public String login() {
        return "login";
    }
	
	@RequestMapping(value = "/index")
	public String indexPage(Model model,HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		SpringBootUser user = dao.findByUserId(auth.getName());
		session.setAttribute("loginUser", user.getUserName());
		user.setLastLoginDate(new Date());
		dao.save(user);
//		return "redirect:/singup";
		return "index";
	}
}
