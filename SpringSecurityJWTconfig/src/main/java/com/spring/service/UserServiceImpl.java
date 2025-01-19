package com.spring.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.config.JwtProvider;
import com.spring.entities.User;
import com.spring.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private final String uploadDir = System.getProperty("user.dir") + "/uploads";

	
	
	@Override
	public User getProfile(String jwt) {

		String email = JwtProvider.getEmailFromJwtToken(jwt);

		return userRepository.findByEmail(email);

	}

	
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	
}
