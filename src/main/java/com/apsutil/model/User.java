package com.apsutil.model;

import javax.persistence.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
 
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.apsutil.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;
 
@Entity
@Table(name="USERS")
@Transactional
public class User implements Serializable{
private static final long serialVersionUID = 1L;
 @Id
@GeneratedValue(strategy = GenerationType.AUTO)
 @JsonView(Views.Public.class)
@Column(name="userid")
private Long userId;
 @JsonView(Views.Public.class)
@Column(name = "username")
private String userName;
@Column(name = "password")
private String password; 
@JsonView(Views.Public.class)
@Column(name = "email")
private String email;
@Column(name ="enabled")
private int enabled;
public User(){
}
public User(User user) {
this.userId = user.userId;
this.userName = user.userName;
this.email = user.email; 
this.password = user.password;
this.enabled=user.enabled; 
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getEnabled() {
	return enabled;
}
public void setEnabled(int enabled) {
	this.enabled = enabled;
}
    
    
    
    
    
}
