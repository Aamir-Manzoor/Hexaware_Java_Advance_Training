package com.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotpot.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
