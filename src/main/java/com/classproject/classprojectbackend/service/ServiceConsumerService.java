package com.classproject.classprojectbackend.service;


import com.classproject.classprojectbackend.Repositories.BranchRepository;
import com.classproject.classprojectbackend.Repositories.ServiceConsumerRepository;
import com.classproject.classprojectbackend.Repositories.ServiceProviderRepository;
import com.classproject.classprojectbackend.entity.Agent;
import com.classproject.classprojectbackend.entity.Branch;
import com.classproject.classprojectbackend.entity.ServiceConsumer;
import com.classproject.classprojectbackend.entity.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceConsumerService {
    @Autowired(required = true)
    public ServiceConsumerRepository serviceConsumerRepo;

    @Autowired(required = true)
    public BranchRepository branchRepo;



    public ArrayList<Branch> getBranches() {

        return  (ArrayList< Branch> )branchRepo.findAll();
    }

    public  void saveServiceConsumer(ServiceConsumer serviceConsumer){

        serviceConsumerRepo.save(serviceConsumer);
    }

    public int getServiceConsumerCount() {

        return  serviceConsumerRepo.getConsumerCount();
    }

    public ServiceConsumer getServiceConsumerByUser(int Id) {

        return  serviceConsumerRepo.getServiceConsumerByUser(Id);
    }

    public ServiceConsumer getServiceConsumer(int Id) {

        return  serviceConsumerRepo.getServiceConsumerById(Id);
    }
}
