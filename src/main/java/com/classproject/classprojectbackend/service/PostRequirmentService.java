package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.BranchRepository;
import com.classproject.classprojectbackend.Repositories.PostRequirementRepository;
import com.classproject.classprojectbackend.Repositories.QuotationRepository;
import com.classproject.classprojectbackend.Repositories.UserRepository;
import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.Quotation;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PostRequirmentService {

    @Autowired(required = true)
    public PostRequirementRepository postRequirementRepository;

    @Autowired(required = true)
    public QuotationRepository quotationRepository;

    public PostRequirement savePostRequirement(PostRequirement postRequirement) {

        return postRequirementRepository.save(postRequirement);
    }

    public ArrayList<PostRequirement> getPostRequirements() {
        return (ArrayList<PostRequirement>) postRequirementRepository.findAll();


    }

    public ArrayList<Quotation> getQuatations(int consumerId) {
        return (ArrayList<Quotation>) quotationRepository.getQuatationByServiceConsumerId(consumerId);


    }

    public  void postQuatation(Quotation quotation){
        quotationRepository.save(quotation);
    }
}

