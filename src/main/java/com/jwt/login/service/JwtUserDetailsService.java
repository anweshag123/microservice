package com.jwt.login.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("roswar11")) {
			return new User("roswar11","Roswar@11", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("user not found with username:"+username);
		}
	}

	
}
