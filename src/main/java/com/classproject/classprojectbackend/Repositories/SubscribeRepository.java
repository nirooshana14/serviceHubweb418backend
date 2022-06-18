package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.ServiceProvider;
import com.classproject.classprojectbackend.entity.Subscribe;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface SubscribeRepository extends CrudRepository<Subscribe,Integer> {

    @Query(value = "SELECT * FROM subscribe WHERE CURDATE()<endDate AND serviceProviderId=?1 and status='subscribed'", nativeQuery = true)
    public Subscribe getSubscribeById(int id);

    @Modifying
    @Query("UPDATE Subscribe s SET s.quotationcount=s.quotationcount-1 WHERE s.subscribeId =?1 and s.status='subscribed'")
    public void UpdateSubscribeQuotation(int subscribeId);

    @Modifying
    @Query("UPDATE Subscribe s SET s.status=?1 WHERE s.subscribeId =?2 ")
    public void UpdateSubscribeDetails(String status,int subscribeId);
}
