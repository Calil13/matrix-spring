package org.example.matrixspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDto {
    private Long id;
    private String name;
    private Set<EmployeeDto> employees;
}
