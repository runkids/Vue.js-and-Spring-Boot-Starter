package com.app.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.app.model.UserRole;

@Transactional
public interface UserRoleDAO extends CrudRepository<UserRole,String> {
	public UserRole findRoleIdByUserId(String userId);
}
