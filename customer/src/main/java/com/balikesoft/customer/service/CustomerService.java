package com.balikesoft.customer.service;

import com.balikesoft.customer.model.Customer;
import com.balikesoft.customer.repository.CustomerRepository;
import com.balikesoft.customer.request.CustomerRegistrationRequest;
import com.balikesoft.customer.response.FraudCheckResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService{
      private final  CustomerRepository customerRepository;
      private final RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer=Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                        .email(request.email())
                        .build();
                //todo:check if email is valid
        // todo:check if email is not taken
        customerRepository.saveAndFlush(customer);
        // todo:check if fraudstar
      FraudCheckResponse fraudCheckResponse=  restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/2",
        FraudCheckResponse.class,
customer.getId()

        );
      //  FraudCheckResponse fraudCheckResponse =  fraudClient.isFraudster(customer.getId());
if (fraudCheckResponse.isFraudSter()){
    throw new IllegalStateException("fraudster");
}
        //todo: send notification

      /*  NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Amigoscode...",
                        customer.getFirstName())
        );

       /* rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
*/
    }
}
