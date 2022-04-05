package com.jwt.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.login.config.JwtTokenUtil;
import com.jwt.login.service.JwtUserDetailsService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	JwtUserDetailsService userDetailsService;
	
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestParam(value="username") String username, @RequestParam(value="password") String password) throws Exception{
		if(!username.equals("roswar11")||!password.equals("Roswar@11"))
			return ResponseEntity.ok("Invalid Credentials!");
		final UserDetails userDetails=userDetailsService.loadUserByUsername(username);
		final String token=jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
		
	}
	@GetMapping("hello")
	 public String hello() {
		return "Hello JWT";
	}
	
	
	
}
