package org.example.matrixspring.service;

import lombok.extern.slf4j.Slf4j;
import org.example.matrixspring.dao.repository.AddressRepository;
import org.example.matrixspring.mapper.AddressMapper;
import org.example.matrixspring.model.AddressDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AddressService {

    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    public AddressService(AddressMapper addressMapper, AddressRepository addressRepository) {
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public List<AddressDto> getAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    public void addAddress(AddressDto addressDto) {
        addressRepository.save(addressMapper.toEntity(addressDto));
    }
}
