package com.example.Rouge.service;

import com.example.Rouge.dao.AddressRepository;
import com.example.Rouge.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address) {
        Optional<Address> existingAddress = addressRepository.findById(id);

        if (existingAddress.isPresent()) {
            Address updatedAddress = existingAddress.get();
            updatedAddress.setStreet(address.getStreet());
            updatedAddress.setCity(address.getCity());
            updatedAddress.setState(address.getState());
            updatedAddress.setZipCode(address.getZipCode());
            return addressRepository.save(updatedAddress);
        } else {
            return null;
        }
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public Address getAddressById(Long id) {
        Optional<Address> address = addressRepository.findById(id);
        return address.orElse(null);
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }
}
