package com.microservice1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice1.entity.User;
import com.microservice1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		Optional<User> opUser = userRepository.findById(id);
		if(opUser.isPresent()) {
			return opUser.get();
		}else return null;
		
	}

	public User updateUser(Long id, User user) {
		Optional<User> opUser = userRepository.findById(id);
		if(opUser.isPresent()) {
			User existingUser = opUser.get();
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			return userRepository.save(existingUser);
		}else return null;
	}

	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "deleted";
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

}
