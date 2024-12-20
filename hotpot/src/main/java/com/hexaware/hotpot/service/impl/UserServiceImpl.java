package com.hexaware.hotpot.service.impl;

import com.hexaware.hotpot.exception.InvalidCredentialsException;
import com.hexaware.hotpot.exception.ResourceNotFoundException;
import com.hexaware.hotpot.models.User;
import com.hexaware.hotpot.repository.UserRepository;
import com.hexaware.hotpot.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        if (existsByUsername(user.getUsername())) {
            throw new InvalidCredentialsException("Username already exists");
        }
        user.setCreatedAt(LocalDateTime.now());
        user.setIsActive(true);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        if (!userRepository.existsById(user.getUserId())) {
            throw new ResourceNotFoundException("User not found");
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
    	return Optional.of(userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId)));
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
    	return Optional.of(userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username)));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(User.UserRole role) {
        return userRepository.findByRole(role);
    }

    @Override
    public boolean deactivateUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setIsActive(false);
            userRepository.save(existingUser);
            return true;
        }
        throw new ResourceNotFoundException("User not found with ID: " + userId);
    }

    @Override
    public boolean activateUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setIsActive(true);
            userRepository.save(existingUser);
            return true;
        }
        throw new ResourceNotFoundException("User not found with ID: " + userId);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
    	  if (!userRepository.existsById(userId)) {
              throw new ResourceNotFoundException("User not found with ID: " + userId);
          }
          userRepository.deleteById(userId);
    }
}
