package org.example.matrixspring.mapper;

import org.example.matrixspring.dao.entity.AddressEntity;
import org.example.matrixspring.model.AddressDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDto toDto(AddressEntity entity);
    AddressEntity toEntity(AddressDto dto);

}
