package com.car.rental.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	@Email(message = "*Please provide a valid email")
	@NotBlank(message = "*Please provide a email")
	private String email;

	@Pattern(regexp = "(^$|[0-9]{10})", message = "*Invalid phone number")
	private String tele;

	@Transient
	private String password;

	public User(User user) {
		
		this.id = user.getId();
		this.email = user.getEmail();
		this.tele = user.getTele();
		this.password = user.getPassword();
	}
}
