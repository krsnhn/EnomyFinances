package com.secnanifymone.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.secnanifymone.models.MyUser;
import com.secnanifymone.models.Role;
import com.secnanifymone.repositories.UserRepository;

@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.print("A new email is being authenticated: " + email);
		MyUser user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("User " + email + " is invalid, please enter again");
		}

		UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();

		String[] roleNames = user.getRoles().stream().map(Role::getName).toArray(String[]::new);

		System.out.println("Role Name from UserDetailServiceImpl is " + roleNames);

		return userBuilder.username(user.getUserName()).password(user.getPassword()).roles(roleNames).build();

	}
}
