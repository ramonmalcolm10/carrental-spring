package com.car.rental.model;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Base64;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.Lob;

import javax.persistence.Transient;

import lombok.Data;


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
	
	//@NotBlank(message = "*Please provide a price")
	private BigDecimal price;
	
	private BigDecimal deposit = new BigDecimal(0);
	
	//@NotBlank(message = "*Please provide how many people can hold in the car")
	private int capacity;
	
	//@NotBlank(message = "*Please provide a minimum days user can rent car for")
	private int minDays;
	
	@NotBlank(message = "*Please provide car conditions")
	private String carCondition;
	
	@NotBlank(message = "*Please provide car transmission")
	private String transmission;
	
	@Lob
    private byte[] pic;
	
	 @Transient
	 private String imgUtility;

	public CarDetails() {
		
	}

	public CarDetails(Long id, User user, @NotBlank(message = "*Please provide a car name") String carName,
			BigDecimal price, BigDecimal deposit, int capacity, int minDays,
			@NotBlank(message = "*Please provide car conditions") String carCondition,
			@NotBlank(message = "*Please provide car transmission") String transmission, byte[] pic,
			String imgUtility) {
		
		this.id = id;
		this.user = user;
		this.carName = carName;
		this.price = price;
		this.deposit = deposit;
		this.capacity = capacity;
		this.minDays = minDays;
		this.carCondition = carCondition;
		this.transmission = transmission;
		this.pic = pic;
		this.imgUtility = imgUtility;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMinDays() {
		return minDays;
	}

	public void setMinDays(int minDays) {
		this.minDays = minDays;
	}

	public String getCarCondition() {
		return carCondition;
	}

	public void setCarCondition(String carCondition) {
		this.carCondition = carCondition;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	
	
	//getter method for encoding
		 public String getImgUtility() throws UnsupportedEncodingException {

		     //byte[] encodeBase64 = Base64.getEncoder().encode(getPic()); //Base64.encodeBase64(getPic());
		     // String base64Encoded = new String(encodeBase64, "UTF-8");   
			 
		     //return base64Encoded;
			 
			 return Base64.getEncoder().encodeToString(getPic());
		 }

	public void setImgUtility(String imgUtility) {
		this.imgUtility = imgUtility;
	}
	
	
	 
	
}


