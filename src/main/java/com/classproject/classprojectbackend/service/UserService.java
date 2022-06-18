package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.UserRepository;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required=true)
    public UserRepository userRepository;

    public Users saveUser(Users user){

        return  userRepository.save(user);
    }

    public Users getUserByEmail(String email){

        return userRepository.getUserByEmail(email);
    };

    public Users getUserByEmailAndPassword(String email,String password){

        return userRepository.getUserByEmailPAndPassword(email,password);
    };

    public Users getUserById(int id){

        return userRepository.getUserById(id);
    };

    public void updateUser(String userName,String address, String contactNumber,String image,int userId){

         userRepository.UpdateUser(userName,address,contactNumber,image,userId);
    };
}
