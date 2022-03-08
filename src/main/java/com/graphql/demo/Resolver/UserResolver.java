package com.graphql.demo.Resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.*;
import com.graphql.demo.Entity.UserModel;
import com.graphql.demo.Service.UserService;
import com.graphql.demo.input.UserModelInput;


@Component
public class UserResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
	
	private UserService userService;
		
	public UserResolver(UserService userService) {	
		this.userService = userService;
	}

	public UserModel addUser(UserModelInput input) {
		
		return userService.addUser(input);
	}

	public List<UserModel> users() {
		
		return userService.users();
	}

	public UserModel user(Long id){
		return userService.user(id);
	}
}
