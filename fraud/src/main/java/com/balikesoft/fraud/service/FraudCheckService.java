package com.balikesoft.fraud.service;

import com.balikesoft.fraud.model.FraudCheckHistory;
import com.balikesoft.fraud.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudRepository fraudRepository;

    public boolean isFraudulentCustomer(Integer customerId) {
        fraudRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}