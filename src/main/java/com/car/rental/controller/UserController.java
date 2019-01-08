package com.car.rental.controller;

import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.car.rental.model.CustomUserDetails;
import com.car.rental.model.User;
import com.car.rental.service.UserService;

@Controller
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/register")
	public String register(User user) {
		return "register";
	}

	@PostMapping("/register")
	public String register(@Valid User user, BindingResult result, Model model) {

		if (userService.emailExist(user.getEmail())) {

			FieldError error = new FieldError("user", "email", user.getEmail(), false, null, null,
					"*Email already exist.");

			result.addError(error);
		}

		if (!userService.passwordStrength(user.getPassword())) {

			FieldError error = new FieldError("user", "password", null, false, null, null,
					"*Your password is too weak.");
			result.addError(error);
		}

		if (result.hasErrors()) {
			return "register";
		}

		if (userService.registerUser(user)) {
			model.addAttribute("successMsg", "You have successfully registered");
			return "login";
		}
		model.addAttribute("errorMsg", "Failed to register please try again");
		return "register";
	}
	
	@GetMapping("/login")
	public String login(User user) {
		return "login";
	}
	
		
}
