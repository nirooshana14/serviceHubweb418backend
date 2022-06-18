package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.AgentRepository;
import com.classproject.classprojectbackend.Repositories.CommentsRepository;
import com.classproject.classprojectbackend.entity.Agent;
import com.classproject.classprojectbackend.entity.Customerlikedcomments;
import com.classproject.classprojectbackend.entity.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgentService {

    @Autowired(required=true)
    private AgentRepository agentRepository;

    public  void saveAgent(Agent agent){
        agentRepository.save(agent);
    }

    public ArrayList<Agent> getAgentByResult() {

        return  (  ArrayList<Agent>)agentRepository.getAgentByResult("Not Accepted");
    }



    public void updatAgentByResult(String result,String promocode,int  agentId) {

        agentRepository.UpdateAgent(result,promocode,agentId);
    }

    public int agentCount() {

        return  agentRepository.getAgentCount();
    }

    public Agent getAgentById(int Id) {

        return  agentRepository.getAgentById(Id);
    }

    public Agent getAgentByUser(int Id) {

        return  agentRepository.getServiceAgentByUser(Id);
    }

    public Agent getAgentByPromo(String promoCode){
        return agentRepository.getServiceAgentByPromo(promoCode);
    }

    public void updatePromoCount(String promoCode) {

        agentRepository.UpdatepromoCount(promoCode);
    }
}
