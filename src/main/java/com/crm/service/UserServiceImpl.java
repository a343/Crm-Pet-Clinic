package com.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public List<String> getRoles() {
		return userRepository.getAuthorities();
	}

}
