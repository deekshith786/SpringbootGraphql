package com.graphql.demo.Service;

import java.util.List;
import java.util.Map;

import com.graphql.demo.error.UserExceptionResolver;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.demo.Entity.UserModel;
import com.graphql.demo.Repository.UserRepository;
import com.graphql.demo.input.UserModelInput;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserModel addUser(UserModelInput input) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> mp = objectMapper.convertValue(input, Map.class);
		UserModel users = objectMapper.convertValue(mp, UserModel.class);
		return userRepository.save(users);
	}

	public List<UserModel> users(){		
		return userRepository.findAll();
	}

	public UserModel user(Long id) {
		if(!userRepository.existsById(id)){
			throw new UserExceptionResolver("User doesnt exitst");
		}
		else
		{
			return userRepository.findById(id).get();
		}
	}
}
