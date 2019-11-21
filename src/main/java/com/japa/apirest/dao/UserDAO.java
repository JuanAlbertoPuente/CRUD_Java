package com.japa.apirest.dao;

import java.util.List;

import com.japa.apirest.entity.User;

public interface UserDAO {

	public List<User> findAll();
	
	public User findById(int id);
	
	public void save(User user);
	
	public void deleteById(int id);
}
