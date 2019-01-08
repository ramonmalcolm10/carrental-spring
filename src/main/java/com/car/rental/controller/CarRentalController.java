package com.car.rental.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.car.rental.model.CustomUserDetails;
import com.car.rental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
public class CarRentalController {

	private final CarService carService;

	@Autowired
	public CarRentalController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/")
	public String index(@AuthenticationPrincipal CustomUserDetails customUserDetails, Model model,
			@RequestParam(defaultValue="0") int page) {
		System.out.println("Index");
		System.out.println(customUserDetails.getEmail());
		System.out.println(customUserDetails.getId());

		Pageable pageable = PageRequest.of(page, 2);

		
		model.addAttribute("cars", carService.getAllCars(pageable));
		return "index";
	}

}
