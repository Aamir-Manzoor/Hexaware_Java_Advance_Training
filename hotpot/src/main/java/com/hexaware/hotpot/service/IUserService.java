package com.hexaware.hotpot.service;

import com.hexaware.hotpot.models.User;
import java.util.List;
import java.util.Optional;

import com.hexaware.hotpot.models.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    User updateUser(User user);
    Optional<User> getUserById(Long userId);
    Optional<User> getUserByUsername(String username);
    List<User> getAllUsers();
    List<User> getUsersByRole(User.UserRole role);
    boolean deactivateUser(Long userId);
    boolean activateUser(Long userId);
    boolean existsByUsername(String username);
    void deleteUser(Long userId);
}