package com.kabeli.evaluacion.mario.echeverria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kabeli.evaluacion.mario.echeverria.entity.User;

public interface IUserRepo extends JpaRepository<User, Integer> {

	public User findByEmail(String email);

	public List<User> findAll();

}
