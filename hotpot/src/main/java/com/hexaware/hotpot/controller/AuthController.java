package com.hexaware.hotpot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.CustomerRegisterDTO;
//import com.hexaware.QuitQApplication.dto.CustomerRegisterDTO;
//import com.hexaware.QuitQApplication.dto.LoginDTO;
//import com.hexaware.QuitQApplication.dto.SellerRegisterDTO;
//import com.hexaware.QuitQApplication.service.IAuthService;
import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDTO;
import com.hexaware.hotpot.dto.RestaurantRegisterDTO;
import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.service.IAuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IAuthService authService;

	public AuthController(IAuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/register/restaurant")
	public ResponseEntity<String> registerRestaurant(@Valid @RequestBody RestaurantRegisterDTO dto) {
		try {
			String value = authService.registerRestaurant(dto);
			return new ResponseEntity<>(value, HttpStatus.CREATED);
		} catch (BadRequestException e) {
			throw new BadRequestException(e.getStatus(), e.getMessage());
		}
	}

	@PostMapping("/register/customer")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerRegisterDTO dto) {
		try {
			String value = authService.registerCustomer(dto);
			return new ResponseEntity<>(value, HttpStatus.CREATED);
		} catch (BadRequestException e) {
			throw new BadRequestException(e.getStatus(), e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> login(@Valid @RequestBody LoginDTO dto) {
		try {
			JWTAuthResponse token = authService.login(dto);
			return ResponseEntity.ok(token);
		} catch (BadRequestException e) {
			throw new BadRequestException(e.getStatus(), e.getMessage());
		}
	}

}