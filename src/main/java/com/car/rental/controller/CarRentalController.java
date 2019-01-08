package com.car.rental.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.car.rental.model.CustomUserDetails;
import com.car.rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CarRentalController {

	private final CarService carService;

	@Autowired
	public CarRentalController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/index")
	public String index(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model) {
		System.out.println("Index");
		System.out.println(customUserDetails.getEmail());
		System.out.println(customUserDetails.getId());
		
		model.addAttribute("cars", carService.getAllCars());
		return "index";
	}

}
