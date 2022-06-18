package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Quotation;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface QuotationRepository extends CrudRepository<Quotation,Integer> {

    @Query(value = "SELECT * FROM quotation where serviceConsumerId= ?1", nativeQuery = true)
    public ArrayList<Quotation> getQuatationByServiceConsumerId(int id);


}
