package com.corespecs.polls9ja.respository.springdatajpa;

import com.corespecs.polls9ja.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}
