package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Packages;
import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface PackageRepository  extends CrudRepository<PostRequirement,Integer> {

    @Modifying
    @Query("update Packages p set p.packageName = ?1,p.price=?2,p.description=?3 where p.packageId = ?4")
    void updatePackage(String packageName, String price,String description,int packageId);

    @Query(value = "SELECT * FROM packages where packageId = ?1 ", nativeQuery = true)
    public Object getPackage(int Id);

}
