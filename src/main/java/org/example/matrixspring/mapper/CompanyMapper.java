package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.entity.CompanyEntity;
import org.example.matrixspring.model.CompanyDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EmployeeMapper.class})
public interface CompanyMapper {

    CompanyDto toDto(CompanyEntity companyEntity);
    CompanyEntity toEntity(CompanyDto companyDto);
}
