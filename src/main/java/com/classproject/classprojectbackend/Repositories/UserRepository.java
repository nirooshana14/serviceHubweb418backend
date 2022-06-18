package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<Users,Integer> {

    @Query(value = "SELECT * FROM users where email= ?1", nativeQuery = true)
    public Users getUserByEmail(String email);

    @Query(value = "SELECT * FROM users where email= ?1 and password=?2", nativeQuery = true)
    public Users getUserByEmailPAndPassword(String email,String password);

    @Query(value = "SELECT * FROM users where userId = ?1 ", nativeQuery = true)
    public Users getUserById(int Id);

    @Query(value = "SELECT * FROM users where email = ?1 and userTypeId=1", nativeQuery = true)
    public Users getUserByEmail2(String email);

    @Modifying
    @Query("update Users u set u.userName = ?1 , u.address=?2,u.contactNumber = ?3 , u.image=?4 where u.userId = ?5")
    public void UpdateUser(String userName,String address, String contactNumber,String image,int userId);

}
