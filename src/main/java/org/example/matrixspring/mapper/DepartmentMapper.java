package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.DepartmentEntity;
import org.example.matrixspring.model.DepartmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto toDto(DepartmentEntity entity);

    DepartmentEntity toEntity(DepartmentDto dto);
}


