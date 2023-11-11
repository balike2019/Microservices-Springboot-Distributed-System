package com.balikesoft.customer.response;

public record FraudCheckResponse(Boolean isFraudSter) {

    public Boolean isFraudSter() {
        return false;

    }
}
