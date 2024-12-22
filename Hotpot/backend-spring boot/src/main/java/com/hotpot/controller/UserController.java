package com.hotpot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotpot.Exception.UserException;
import com.hotpot.model.User;
import com.hotpot.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfileHandler(@RequestHeader("Authorization") String jwt) throws UserException {
        User user = userService.findUserProfileByJwt(jwt);
        
        // Create a new user object without sensitive information
        User sanitizedUser = new User();
        BeanUtils.copyProperties(user, sanitizedUser);
        sanitizedUser.setPassword(null);

        return new ResponseEntity<>(sanitizedUser, HttpStatus.OK);
    }
}