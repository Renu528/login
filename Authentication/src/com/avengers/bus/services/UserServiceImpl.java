package com.avengers.bus.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.avengers.bus.daos.UserDao;
import com.avengers.bus.entityModels.User;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Override

	public boolean verifylogin(String email, String password) {
		User user = userdao.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Transactional()
	public List<User> listAll() {
		return userdao.getAllUsers();

	}

}
