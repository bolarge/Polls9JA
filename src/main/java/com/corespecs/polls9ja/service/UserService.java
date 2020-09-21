package com.corespecs.polls9ja.service;

import com.corespecs.polls9ja.domain.User;

import java.util.Collection;

public interface UserService {

    User saveUser(User user) throws Exception;

    Collection<User> fetchAllUsers();
}
