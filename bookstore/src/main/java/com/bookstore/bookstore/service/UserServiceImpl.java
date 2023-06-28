package com.bookstore.bookstore.service;

import static com.bookstore.bookstore.service.RoleServiceImpl.DEFAULT_ROLE;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.model.Role;
import com.bookstore.bookstore.model.UserModel;
import com.bookstore.bookstore.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserModel createUser(UserModel user) {
		if (checkIfUserAlreadyExist(user.getEmail()))
			throw new RuntimeException("User with email  " + user.getEmail() + " already exists");

		Set<Role> roles = new HashSet<>();
		roles.add(roleService.findRoleByName(DEFAULT_ROLE));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(roles);
		return userRepository.save(user);

		
	}

	@Override
	public UserModel getAuthenticatedUser() {
		return userRepository.findUserModelByEmail(SecurityContextHolder.getContext().getAuthentication().getName())
				.orElseThrow(() -> new RuntimeException("Error retrieving user from security context"));
	}

	@Override
	public boolean checkIfUserAlreadyExist(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public void updateUser(UserModel user) {
		UserModel oldUser = getAuthenticatedUser();
		oldUser.setAddress(user.getAddress());
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setEmail(user.getEmail());
		oldUser.setMobilePhone(user.getMobilePhone());
		
		userRepository.saveAndFlush(oldUser);
		
		
		
	}
	
	
	
	
	

}
