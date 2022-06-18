package com.classproject.classprojectbackend.controler;

import com.classproject.classprojectbackend.entity.Customer;
import com.classproject.classprojectbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControler {

    @Autowired(required=true)
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer customer1;
        try{
             customer1=customerService.saveCustomer(customer);
             return new ResponseEntity<Customer>(customer1, HttpStatus.OK);

        }catch (Exception ex){
            return null;
        }



    }
}
