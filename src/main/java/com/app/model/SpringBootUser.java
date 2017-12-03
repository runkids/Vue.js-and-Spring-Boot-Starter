package com.app.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="SPRING_BOOT_USER")
public class SpringBootUser implements Serializable { 
	
	public SpringBootUser(){
	}
	
	public SpringBootUser(String userName,String userId,int userType,Date createDate){
		this.userName = userName;
		this.userId = userId;
		this.userType = userType;
		this.createDate = createDate;
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="USER_ID",nullable = false)
	@Size(max=50)
	private String userId;
	
	@Column(name="USER_NAME",nullable = false)
	@Size(max=50)
    private String userName;  
	
	@Column(name="USER_PASSWORD",nullable = false)
    private String userPassword;
	
	@Column(name="USER_TYPE",nullable = false)
	private int userType;
	
	@Column(name="CREATE_DATE",nullable = false)	
	private Date createDate;
	
	@Column(name="LAST_LOGIN_DATE")	
	private Date lastLoginDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate ;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
} 