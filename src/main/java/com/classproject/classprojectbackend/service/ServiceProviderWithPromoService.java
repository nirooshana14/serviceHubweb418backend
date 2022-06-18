package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.AgentRepository;
import com.classproject.classprojectbackend.Repositories.PostRequirementRepository;
import com.classproject.classprojectbackend.Repositories.ServiceProviderWithPromoRepository;
import com.classproject.classprojectbackend.Repositories.UserRepository;
import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.ServiceProvider;
import com.classproject.classprojectbackend.entity.ServiceProviderWithPromo;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderWithPromoService {

    @Autowired(required = true)
    public ServiceProviderWithPromoRepository serviceProviderWithPromorepository;

    @Autowired(required = true)
    public AgentRepository agentService;

    @Autowired(required = true)
    public UserRepository userService;



    public ServiceProviderWithPromo saveServiceProvider(ServiceProviderWithPromo serviceProviderWithPromo) {

        return serviceProviderWithPromorepository.save(serviceProviderWithPromo);
    }

    public String getEmail(String email) {
     Users user=userService.getUserByEmail2(email);
        if(user==null){
            return "no valid email";
        }else{
            return "valid email";
        }
    }


}
