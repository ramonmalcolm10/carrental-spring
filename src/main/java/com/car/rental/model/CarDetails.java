package com.car.rental.model;

import java.math.BigDecimal;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.JoinTable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class CarDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;
	
	@NotBlank(message = "*Please provide a car name")
	private String carName;
	
	@NotBlank(message = "*Please provide a price")
	private BigDecimal price;
	
	private BigDecimal deposit = new BigDecimal(0);
	
	@NotBlank(message = "*Please provide how many people can hold in the car")
	private int capacity;
	
	@NotBlank(message = "*Please provide a minimum days user can rent car for")
	private int minDays;
	
	@NotBlank(message = "*Please provide car conditions")
	private String carCondition;
	
	@NotBlank(message = "*Please provide car transmission")
	private String transmission;
	
	private enum Cars{
		ToyotaAxio,
		HondaFit,
		HondaAccord,
		HondaCivic,
		Demio
	}
	
	private enum Condition{
		Excellent,
		Good,
		Poor
	}
	
	private enum Transmission{
		Automatic,
		Manual
	}

	
	
	
}


