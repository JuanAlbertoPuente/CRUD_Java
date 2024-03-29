package com.japa.apirest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.japa.apirest.entity.User;
import com.japa.apirest.service.UserService;


@RestController
@RequestMapping("/api") 
public class UserRestController {
	
	
	@Autowired
	private UserService userService;


	@GetMapping("/users")
	public List<User> findAll(){

		return userService.findAll();
	}
	

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId){
		User user = userService.findById(userId);
		
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}

		return user;
	}
	

	@PostMapping("/users/{userId}")
	public User addUser(@RequestBody User user) {
		user.setId(0);
		

		userService.save(user);
		
		return user;
		
	}
	
	@PatchMapping("/users/{userId}")
	public User updateid(@RequestBody User user) {
		user.setId(0);
		

		userService.save(user);
		
		return user;
		
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		
		userService.save(user);
		
		return user;
	}
	

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		
		userService.deleteById(userId);
		
	}

	
}
