package com.balikesoft.customer.request;

import org.springframework.stereotype.Component;


public record CustomerRegistrationRequest(String firstName,String lastName,String email) {

}
