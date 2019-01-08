package com.car.rental.controller;

import com.car.rental.model.CarDetails;
import com.car.rental.service.CarService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class WebServiceController {

	private final CarService carService;

	@Autowired
	public WebServiceController(CarService carService) {
		this.carService = carService;
	}
	
	@GetMapping("/car")
	public Iterable<CarDetails> getAllCars() {
		return carService.getAllCars();
	}
}
