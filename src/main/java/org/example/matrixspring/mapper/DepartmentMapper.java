package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.entity.DepartmentEntity;
import org.example.matrixspring.model.DepartmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CompanyMapper.class})
public interface DepartmentMapper {

    DepartmentDto toDto(DepartmentEntity entity);

    DepartmentEntity toEntity(DepartmentDto dto);
}


