package com.app.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.app.model.SpringBootUser;

@Transactional
public interface SpringBootUserDAO extends CrudRepository<SpringBootUser,String> {
	
	public SpringBootUser findByUserName(String userName);
	
	public SpringBootUser findByUserId(String userId);
	
	public List<SpringBootUser> findTypeByUserTypeOrUserId(int userType,String userId);
}
