package com.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotpot.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
