package com.corespecs.polls9ja.service.impl;

import com.corespecs.polls9ja.domain.Role;
import com.corespecs.polls9ja.domain.User;
import com.corespecs.polls9ja.respository.springdatajpa.UserRepository;
import com.corespecs.polls9ja.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveUser(User user) throws Exception {

        if(user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new Exception("User must have at least a role set!");
        }

        /*for (Role role : user.getRoles()) {
            if(!role.getName().startsWith("ROLE_")) {
                role.setName("ROLE_" + role.getName());
            }

            if(role.getUser() == null) {
                role.setUser(user);
            }
        }*/
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<User> fetchAllUsers() {
        return (Collection<User>) userRepository.findAll();
    }
}
