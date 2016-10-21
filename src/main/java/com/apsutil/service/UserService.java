package com.apsutil.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apsutil.model.User;
public interface UserService {
	User findById(Long id);
    User findByUserName(String userName);
    public List<String> findRoleByUserName(String userName);
}
