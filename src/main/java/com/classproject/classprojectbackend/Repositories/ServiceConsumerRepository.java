package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.ServiceConsumer;
import com.classproject.classprojectbackend.entity.ServiceProvider;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ServiceConsumerRepository  extends CrudRepository<ServiceConsumer,Integer> {

    @Query(value = "SELECT COUNT(*) FROM serviceconsumer", nativeQuery = true)
    public int getConsumerCount();

    @Query(value = "SELECT * FROM serviceconsumer where userId = ?1 ", nativeQuery = true)
    public ServiceConsumer getServiceConsumerByUser(int userId);

    @Query(value = "SELECT * FROM serviceconsumer where serviceConsumerId = ?1 ", nativeQuery = true)
    public ServiceConsumer getServiceConsumerById(int serviceConsumerId);
}
