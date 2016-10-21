package com.apsutil.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsutil.dao.UserDao;
import com.apsutil.model.User;
import com.apsutil.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findByUserName(userName);
	}

	@Override
	public List<String> findRoleByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.findRoleByUserName(userName);
	}

}
