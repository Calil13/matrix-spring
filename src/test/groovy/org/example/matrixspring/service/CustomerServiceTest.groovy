package org.example.matrixspring.service

import org.example.matrixspring.dao.entity.Customer
import org.example.matrixspring.dao.repository.CustomerRepository
import org.springframework.http.HttpStatus
import spock.lang.Specification

class CustomerServiceTest extends Specification {
    private  CustomerRepository customerRepository
    private  OtpService otpService
    private CustomerService customerService

    void setup() {
        customerRepository = Mock()
        otpService = Mock()
        customerService = new CustomerService(customerRepository, otpService)
    }

    def "getAllCustomers should return all customers when otp is valid"() {
        given:
        def otpCode = "123456"
        def customerEntity = new Customer(1, "Test", "test@gmail.com")

        when:
        def actual = customerService.getAllCustomers(otpCode)

        then:
        1 * otpService.validateOtp(otpCode)
        1 * customerRepository.findAll() >> List.of(customerEntity)
        actual.statusCode == HttpStatus.OK
        actual.body == List.of(customerEntity)
    }

    def "getAllCustomers should return FORBIDDEN when otp is invalid"() {
        given:
        def otpCode = "wrong"

        when:
        def actual = customerService.getAllCustomers(otpCode)

        then:
        1 * otpService.validateOtp(otpCode) >> { throw new IllegalArgumentException("Invalid OTP") }
        0 * customerRepository.findAll()
        actual.statusCode == HttpStatus.FORBIDDEN
        actual.body == "Invalid OTP"
    }
}
