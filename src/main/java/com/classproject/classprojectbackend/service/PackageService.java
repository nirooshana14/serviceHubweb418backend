package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.AgentRepository;
import com.classproject.classprojectbackend.Repositories.PackageRepository;
import com.classproject.classprojectbackend.entity.Agent;
import com.classproject.classprojectbackend.entity.Packages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PackageService {

    @Autowired(required=true)
    private PackageRepository packageRepository;


    public Object getAPackage(int id) {

        return packageRepository.getPackage(id);
    }



    public void updatePackage(String packageName, String price,String description,int packageId) {

        packageRepository.updatePackage(packageName,price,description,packageId);
    }
}
