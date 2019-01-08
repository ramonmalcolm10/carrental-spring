package com.car.rental.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.car.rental.model.CarDetails;

public interface CarDetailsRepository extends CrudRepository<CarDetails, Long> {

	Optional<List<CarDetails>> findByCarName(String carName);
	Optional<List<CarDetails>> findByUser(String userid);
}
