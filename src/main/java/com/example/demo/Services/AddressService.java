package com.example.demo.Services;

import com.example.demo.Entities.Address;
import com.example.demo.Repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    AddressRepo addressRepo;
    public Address insertAdd(Address address){
        return addressRepo.save(address);
    }

}
