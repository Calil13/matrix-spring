package org.example.matrixspring.service;

import org.example.matrixspring.dao.repository.EmployeeRepository;
import org.example.matrixspring.mapper.EmployeeMapper;
import org.example.matrixspring.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private  final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().
                stream().
                map(employeeMapper::toDto).
                collect(Collectors.toList());
    }
}
