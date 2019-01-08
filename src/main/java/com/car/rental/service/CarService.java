package com.car.rental.service;

import org.springframework.stereotype.Service;

import com.car.rental.model.CarDetails;
import com.car.rental.repository.CarDetailsRepository;

@Service
public class CarService {

	private final CarDetailsRepository carDetailsRepository;

	public CarService(CarDetailsRepository carDetailsRepository) {
		this.carDetailsRepository = carDetailsRepository;
	}
	
	
	public Boolean uploadCarData(CarDetails carDetails) {
		try {
			carDetailsRepository.save(carDetails);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Iterable<CarDetails> getAllCars() {
		
		return carDetailsRepository.findAll();
	}
	
}
