package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.entities.User;
import com.spring.service.UserService;


@Controller
@RequestMapping("/api/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	
	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfile (@RequestHeader("Authorization") String jwt){
		
		User user = userService.getProfile(jwt);
		
		return new ResponseEntity<>(user , HttpStatus.OK);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getUsers (@RequestHeader("Authorization") String jwt){
		
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<>(users , HttpStatus.OK);
	}

}
