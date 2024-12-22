package com.hotpot.service;

import java.util.List;

import com.hotpot.Exception.ReviewException;
import com.hotpot.model.Review;
import com.hotpot.model.User;
import com.hotpot.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
