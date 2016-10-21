package com.apsutil.dao;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.stereotype.Repository;

import com.apsutil.model.User;
public interface UserDao {
	User findById(Long id);
    User findByUserName(String userName);
    public List<String> findRoleByUserName(String userName);
}
