package org.example.matrixspring.controller;

import org.example.matrixspring.model.AddressDto;
import org.example.matrixspring.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> getAddresses() {
        return addressService.getAddresses();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody AddressDto addressDto) {
        addressService.addAddress(addressDto);
    }
}
