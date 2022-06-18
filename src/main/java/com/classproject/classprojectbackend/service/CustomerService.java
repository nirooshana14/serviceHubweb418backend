package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.CustomerRepository;
import com.classproject.classprojectbackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired(required=true)
    private CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer){
        return  customerRepository.save(customer);
    }

}
