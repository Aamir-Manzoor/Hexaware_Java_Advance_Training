package com.hotpot.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotpot.Exception.UserException;
import com.hotpot.config.JwtProvider;
import com.hotpot.model.PasswordResetToken;
import com.hotpot.model.User;
import com.hotpot.repository.PasswordResetTokenRepository;
import com.hotpot.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final JavaMailSender javaMailSender;
    
    @Autowired
    public UserServiceImplementation(
            UserRepository userRepository,
            JwtProvider jwtProvider,
            PasswordEncoder passwordEncoder,
            PasswordResetTokenRepository passwordResetTokenRepository,
            JavaMailSender javaMailSender) {
        
        this.userRepository = userRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public User findUserProfileByJwt(String jwt) throws UserException {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        
        User user = userRepository.findByEmail(email);
        
        if(user == null) {
            throw new UserException("User not found with email: " + email);
        }
        
        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getPenddingRestaurantOwner() {
        return userRepository.getPenddingRestaurantOwners();
    }
    
    @Override
    public void updatePassword(User user, String newPassword) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void sendPasswordResetEmail(User user) {
        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        
        String resetToken = generateRandomToken();
        Date expiryDate = calculateExpiryDate();

        // Save the token in the database
        PasswordResetToken passwordResetToken = new PasswordResetToken(resetToken, user, expiryDate);
        passwordResetTokenRepository.save(passwordResetToken);

        // Send reset link email
        String resetLink = "http://localhost:3000/account/reset-password?token=" + resetToken;
        sendEmail(
            user.getEmail(),
            "Password Reset Request",
            "To reset your password, click the following link: " + resetLink + 
            "\nThis link will expire in 10 minutes."
        );
    }

    private void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("noreply@yourapp.com"); // Add your application's email

        javaMailSender.send(mailMessage);
    }

    private String generateRandomToken() {
        return UUID.randomUUID().toString();
    }

    private Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 10); // Token expires in 10 minutes
        return cal.getTime();
    }
    
    @Override
    public User findUserByEmail(String email) throws UserException {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        
        User user = userRepository.findByEmail(email);
        
        if(user == null) {
            throw new UserException("User not found with email: " + email);
        }
        
        return user;
    }
}