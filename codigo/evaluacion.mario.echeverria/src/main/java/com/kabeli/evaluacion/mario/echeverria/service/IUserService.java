package com.kabeli.evaluacion.mario.echeverria.service;

import java.util.List;

import com.kabeli.evaluacion.mario.echeverria.entity.User;

public interface IUserService {
	public User save(User usuario);
	public List<User> getAllUsers();
	public User findByEmail(String email);
}
