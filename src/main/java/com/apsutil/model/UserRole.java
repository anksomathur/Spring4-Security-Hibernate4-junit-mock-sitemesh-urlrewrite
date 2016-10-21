package com.apsutil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="USER_ROLES")
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO) 
@Column(name="user_role_id")
private Long userroleid;
@Column(name="userid")
private Long userid;

@Column(name="roleid")
private Long roleid;

public Long getRoleid() {
	return roleid;
}

public void setRoleid(Long roleid) {
	this.roleid = roleid;
}

public Long getUserroleid() {
	return userroleid;
}

public void setUserroleid(Long userroleid) {
	this.userroleid = userroleid;
}

public Long getUserid() {
	return userid;
}

public void setUserid(Long userid) {
	this.userid = userid;
}


}
