package com.trilogy.project.service;

import java.util.List;
import java.util.Optional;

import com.trilogy.project.model.User;

public interface UserService {
	User findById(Long id);
	User findUserByEmail(String email);
	User saveUser(User user);
	List<User> findAllUsers();
	User deleteUserById(Long id);
}