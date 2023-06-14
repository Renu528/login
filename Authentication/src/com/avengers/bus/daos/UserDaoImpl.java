package com.avengers.bus.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.avengers.bus.entityModels.User;

@Component
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public User findByEmail(String email) {
		boolean e = em.contains(email);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		return em.createQuery("SELECT u FROM User u").getResultList();
	}

}
