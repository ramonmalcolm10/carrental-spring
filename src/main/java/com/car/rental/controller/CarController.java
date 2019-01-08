package com.car.rental.controller;

import java.io.IOException;
import javax.validation.Valid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.car.rental.model.CarDetails;
import com.car.rental.model.CustomUserDetails;
import com.car.rental.service.CarService;

@Controller
public class CarController {

	private final CarService carService;

	@Autowired
	public CarController(CarService carService) {
		this.carService = carService;
	}

	@GetMapping("/car/upload")
	public String carUpload(CarDetails carDetails) {
		return "car-upload";
	}

	@PostMapping("/car/upload")
	public String carUploadSave(@Valid CarDetails carDetails, BindingResult result, Model model,
			@RequestParam("file") MultipartFile file, @AuthenticationPrincipal CustomUserDetails customUserDetails)
			throws IOException {

		if (result.hasErrors()) {
			return "car-upload";
		}
		carDetails.setUser(customUserDetails);
		carDetails.setPic(file.getBytes());
		if (carService.uploadCarData(carDetails))
			model.addAttribute("successMsg", "Upload successfull");
		else
			model.addAttribute("errorMsg", "Failed to register please try again");

		return "car-upload";
	}

}
