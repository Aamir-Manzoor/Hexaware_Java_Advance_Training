package com.hexaware.hotpot.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.hexaware.hotpot.models.Order.OrderStatus;
import java.io.IOException;

public class OrderStatusDeserializer extends JsonDeserializer<OrderStatus> {
    @Override
    public OrderStatus deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText().toUpperCase().trim();
        try {
            return OrderStatus.valueOf(value);
        } catch (IllegalArgumentException e) {
            // Fallback to default value if the incoming value doesn't match
            return OrderStatus.PENDING;
        }
    }
}