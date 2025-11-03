package org.example.matrixspring.dao.repository;

import org.example.matrixspring.dao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
