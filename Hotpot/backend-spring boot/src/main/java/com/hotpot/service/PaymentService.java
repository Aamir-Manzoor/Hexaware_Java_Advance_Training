package com.hotpot.service;

import com.hotpot.model.Order;
import com.hotpot.model.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
