package com.car.rental.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.car.rental.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	 Optional<User> findByEmail(String email);
}
