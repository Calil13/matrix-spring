package org.example.matrixspring.service;

import lombok.RequiredArgsConstructor;
import org.example.matrixspring.dao.entity.Customer;
import org.example.matrixspring.dao.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
