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

import com.car.rental.model.CarDetails;

@Controller
public class CarController {

	@GetMapping("/car/upload")
	public String carUpload() {
		return "car-upload";
	}
	
	@PostMapping("/car/upload")
	public String carUploadSave(@Valid CarDetails carDetails, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "car-upload";
		}
		
		return "car-upload";
	}
	
	
}
