package com.car.rental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.car.rental.model.CustomUserDetails;
import com.car.rental.model.User;
import com.car.rental.repository.UserRepository;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public Boolean registerUser(User user) {
		try {
		
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean emailExist(String email) {
		Optional<User> userExists = userRepository.findByEmail(email);
		return userExists.isPresent();
	}

	public Boolean passwordStrength(String password) {

		Zxcvbn passwordCheck = new Zxcvbn();

		Strength strength = passwordCheck.measure(password);

		if (strength.getScore() < 3) {
			return false;
		}
		return true;
	}

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByEmail(email);

		user.orElseThrow(() -> new UsernameNotFoundException("Email not found"));

		return user.map(CustomUserDetails::new).get();
	}

}
