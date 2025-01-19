package com.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.entities.User;




@Service
public interface UserService {
	
	public User getProfile (String jwt);

	public List<User> getAllUsers();
	
	
	

}
