package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.CustomerRepository;
import com.classproject.classprojectbackend.Repositories.UserTypeRepository;
import com.classproject.classprojectbackend.entity.Customer;
import com.classproject.classprojectbackend.entity.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserTypeService {

    @Autowired(required=true)
    private UserTypeRepository userTypeRepository;

    public ArrayList<UserType> getUserType(){
        return  (ArrayList<UserType>)userTypeRepository.findAll();
    }



}
