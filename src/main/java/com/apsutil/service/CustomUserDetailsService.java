package com.apsutil.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apsutil.model.CustomUserDetails;
import com.apsutil.model.User;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user=userService.findByUserName(userName);
		if(null == user){
		throw new UsernameNotFoundException("No user present with username: "+userName);
		}else{
		List<String> userRoles=userService.findRoleByUserName(userName);
		return new CustomUserDetails(user, userRoles);
		}
	}
}
