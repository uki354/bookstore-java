package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.UserModel;

public interface UserService {
	
	 UserModel createUser(UserModel userModel);
	 UserModel getAuthenticatedUser();
	 boolean checkIfUserAlreadyExist(String email);
	 void updateUser(UserModel user);
}
