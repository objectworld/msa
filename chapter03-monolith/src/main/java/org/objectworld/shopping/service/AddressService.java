package org.objectworld.shopping.service;

import org.objectworld.shopping.domain.Address;
import org.objectworld.shopping.dto.AddressDto;
import org.objectworld.util.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    public static AddressDto mapToDto(Address address) {
    	return ObjectMapper.map(address, AddressDto.class);
    }

    public static Address createFromDto(AddressDto addressDto) {
        return ObjectMapper.map(addressDto, Address.class);
    }
}
	