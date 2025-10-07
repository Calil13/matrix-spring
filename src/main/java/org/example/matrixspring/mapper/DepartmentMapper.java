package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.entity.DepartmentEntity;
import org.example.matrixspring.model.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressMapper.class, CompanyMapper.class})
public interface DepartmentMapper {

    DepartmentDto toDto(DepartmentEntity entity);

    @Mapping(target = "departmentId", ignore = true)
    DepartmentEntity toEntity(DepartmentDto dto);
}


