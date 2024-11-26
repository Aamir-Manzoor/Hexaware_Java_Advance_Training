package com.hexaware.hotpot.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.CustomerRegisterDTO;
import com.hexaware.hotpot.dto.JWTAuthResponse;
import com.hexaware.hotpot.dto.LoginDTO;
import com.hexaware.hotpot.dto.RestaurantRegisterDTO;
import com.hexaware.hotpot.dto.UserDTO;
import com.hexaware.hotpot.exception.BadRequestException;
import com.hexaware.hotpot.models.Customer;
import com.hexaware.hotpot.models.Restaurant;
import com.hexaware.hotpot.models.User;
import com.hexaware.hotpot.repository.CustomerRepository;
import com.hexaware.hotpot.repository.RestaurantRepository;
import com.hexaware.hotpot.repository.UserRepository;
import com.hexaware.hotpot.security.JwtTokenProvider;
import com.hexaware.hotpot.service.IAuthService;

//import com.hexaware.QuitQApplication.dto.CustomerRegisterDTO;
//import com.hexaware.QuitQApplication.dto.JWTAuthResponse;
//import com.hexaware.QuitQApplication.dto.LoginDTO;
//import com.hexaware.QuitQApplication.dto.SellerRegisterDTO;
//import com.hexaware.QuitQApplication.dto.UserDTO;
//import com.hexaware.QuitQApplication.exception.BadRequestException;
//import com.hexaware.QuitQApplication.exception.ResourceNotFoundException;
//import com.hexaware.QuitQApplication.model.Customer;
//import com.hexaware.QuitQApplication.model.Seller;
//import com.hexaware.QuitQApplication.model.User;
//import com.hexaware.QuitQApplication.repository.CustomerRepository;
//import com.hexaware.QuitQApplication.repository.SellerRepository;
//import com.hexaware.QuitQApplication.repository.UserRepository;
//import com.hexaware.QuitQApplication.security.JwtTokenProvider;
//import com.hexaware.QuitQApplication.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {

	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	private final CustomerRepository customerRepository;
	private final RestaurantRepository restaurantRepository;
	private final JwtTokenProvider jwtTokenProvider;
	private final ModelMapper mapper;

	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			CustomerRepository customerRepository, RestaurantRepository restaurantRepository, PasswordEncoder passwordEncoder,
			JwtTokenProvider jwtTokenProvider, ModelMapper mapper) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.customerRepository = customerRepository;
		this.restaurantRepository = restaurantRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
		this.mapper = mapper;
	}

	@Override
	public JWTAuthResponse login(LoginDTO dto) {
		try {
			// Authenticate the user
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

			// Set the authentication context
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// Generate JWT token
			String token = jwtTokenProvider.generateToken(authentication);

			// Fetch user details
			User user = userRepository.findByUsername(dto.getUsername()).get();
//					.orElseThrow(() -> new ResourceNotFoundException("User", "username", dto.getUsername()));

			UserDTO userDTO = mapper.map(user, UserDTO.class);
			return new JWTAuthResponse(token, userDTO);

		} catch (Exception ex) {
			throw new BadRequestException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
		}
	}

	@Override
	public String registerCustomer(CustomerRegisterDTO dto) {
		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists");
		}

//		if (userRepository.existsByEmail(dto.getEmail())) {
//			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exists");
//		}

		// Create User entity and set the hashed password
		User user = mapper.map(dto, User.class);
		String hashedPassword = passwordEncoder.encode(dto.getPassword());
		user.setPassword(hashedPassword); // Set the encoded password here
		userRepository.save(user);

		// Create Customer entity and save it
		Customer customer = mapper.map(dto, Customer.class);
		customerRepository.save(customer);

		return "Customer registered successfully!";
	}

	@Override
	public String registerRestaurant(RestaurantRegisterDTO dto) {
		if (userRepository.existsByUsername(dto.getUsername())) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Username already exists");
		}
//
//		if (userRepository.existsByEmail(dto.getEmail())) {
//			throw new BadRequestException(HttpStatus.BAD_REQUEST, "Email already exists");
//		}

		// Create User entity and set the hashed password
		User user = mapper.map(dto, User.class);
		String hashedPassword = passwordEncoder.encode(dto.getPassword());
		user.setPassword(hashedPassword); // Set the encoded password here
		userRepository.save(user);

		// Create Restaurant entity and save it
		Restaurant  restaurant= mapper.map(dto, Restaurant.class);
		restaurantRepository.save(restaurant);

		return "Restaurant registered successfully!";
	}
}
