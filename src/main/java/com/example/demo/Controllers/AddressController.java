package com.example.demo.Controllers;

import com.example.demo.Entities.Address;
import com.example.demo.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("/insertAdd")
    public String insert(@RequestBody Address address){
        addressService.insertAdd(address);
        return "Address inserted successfully";
    }
}
