package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.entity.EmployeeEntity;
import org.example.matrixspring.model.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(EmployeeEntity employeeEntity);
    EmployeeEntity toEntity(EmployeeDto employeeDto);
}
