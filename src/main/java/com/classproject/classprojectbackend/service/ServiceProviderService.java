package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.AgentRepository;
import com.classproject.classprojectbackend.Repositories.ServiceProviderRepository;
import com.classproject.classprojectbackend.Repositories.ServiceProviderWithPromoRepository;
import com.classproject.classprojectbackend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class ServiceProviderService {
    @Autowired(required = true)
    public ServiceProviderRepository serviceProviderRepo;

    public ArrayList<ServiceProvider>  getServiceProvider() {

       return  (ArrayList< ServiceProvider> )serviceProviderRepo.findAll();
    }

    public ArrayList<ServiceProvider>  getServiceProviderByResult() {

        return  (ArrayList< ServiceProvider> )serviceProviderRepo.getServiceProviderByResult("Not Accepted");
    }

    public ArrayList<ServiceProvider>  getServiceProviderByLocation(int location) {

        return  (ArrayList< ServiceProvider> )serviceProviderRepo.getServiceProviderByLocation(location);
    }

    public ArrayList<ServiceProvider>  getServiceProviderByCategory(String category) {
        System.out.println(category);

        return  (ArrayList< ServiceProvider> )serviceProviderRepo.getServiceProviderByCategory(category);
    }

    public ArrayList<ServiceProvider>  getServiceProviderByCategoryAndLocation(int location,String category) {

        return  (ArrayList< ServiceProvider> )serviceProviderRepo.getServiceProviderByLocationAndCategory(location,category);
    }

    public ServiceProvider getServiceProviderByUserId(int id){

        return serviceProviderRepo.getServiceProviderByUserId(id);
    }

    public void updateServiceProviderByResult(int  serviceProviderId,String result) {

        serviceProviderRepo.UpdateServiceProvidersResult(result,serviceProviderId);
    }

    public  void saveServiceProvider(ServiceProvider serviceProvider){
        serviceProviderRepo.save(serviceProvider);
    }

    public int getServiceProviserCount() {

        return  serviceProviderRepo.getServiceProviderCount();
    }

    public ServiceProvider getServiceProviderByUser(int Id) {

        return  serviceProviderRepo.getServiceProviderByUser(Id);
    }
}
