package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Customerlikedcomments;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface CustomerlikedcommentsRepository extends CrudRepository<Customerlikedcomments, Integer> {

    @Query(value = "SELECT * from customerlikedcomments where customerId =?1", nativeQuery = true)
    public ArrayList<Customerlikedcomments> getLikedCommentsBy(int customerId);


}
