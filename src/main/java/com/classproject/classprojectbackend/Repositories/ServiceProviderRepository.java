package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Question;
import com.classproject.classprojectbackend.entity.ServiceProvider;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface ServiceProviderRepository extends CrudRepository<ServiceProvider,Integer> {

    @Query(value = "SELECT * FROM serviceprovider where serviceProviderId = ?1 ", nativeQuery = true)
    public ServiceProvider getServiceProviderByUserId(int serviceProviderId);

    @Query(value = "SELECT * FROM serviceprovider where userId = ?1 ", nativeQuery = true)
    public ServiceProvider getServiceProviderByUser(int userId);

    @Query(value = "SELECT * FROM serviceprovider where category LIKE %?1% ", nativeQuery = true)
    public ArrayList<ServiceProvider> getServiceProviderByCategory(String category);

    @Query(value = "SELECT * FROM serviceprovider where location = ?1  ", nativeQuery = true)
    public ArrayList<ServiceProvider> getServiceProviderByLocation(int location);

    @Query(value = "SELECT * FROM serviceprovider where location = ?1 and  category LIKE ?2", nativeQuery = true)
    public ArrayList<ServiceProvider> getServiceProviderByLocationAndCategory(int location,String category);

    @Query(value = "SELECT * FROM serviceprovider where result = ?1 ", nativeQuery = true)
    public ArrayList<ServiceProvider> getServiceProviderByResult(String result);

    @Modifying
    @Query("update ServiceProvider s set s.result = ?1 where s.serviceProviderId = ?2")
    void UpdateServiceProvidersResult(String result, int serviceProviderId);

    @Query(value = "SELECT COUNT(*) FROM serviceprovider ", nativeQuery = true)
    public int getServiceProviderCount();
}
