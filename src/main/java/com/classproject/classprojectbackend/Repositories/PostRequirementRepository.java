package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Customer;
import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PostRequirementRepository extends CrudRepository<PostRequirement,Integer> {




}
