package org.example.matrixspring.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.entity.Customer;
import org.example.matrixspring.dao.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OtpService otpService;

    public ResponseEntity<?> getAllCustomers(String otpCode) {

        try {
            otpService.validateOtp(otpCode);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }
}
