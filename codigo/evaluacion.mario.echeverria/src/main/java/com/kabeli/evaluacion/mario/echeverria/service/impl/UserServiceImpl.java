package com.kabeli.evaluacion.mario.echeverria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kabeli.evaluacion.mario.echeverria.entity.User;
import com.kabeli.evaluacion.mario.echeverria.repository.IUserRepo;
import com.kabeli.evaluacion.mario.echeverria.service.IUserService;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	private IUserRepo userRepo;

	@Override
	public User save(User usuario) {
		return userRepo.save(usuario);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
