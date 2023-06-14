package com.avengers.bus.daos;

import java.util.List;

import com.avengers.bus.entityModels.User;

public interface UserDao {
	public User findByEmail(String email);

	public List<User> getAllUsers();

}
