package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
