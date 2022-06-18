package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.Replies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface RepliesRepositories extends CrudRepository<Replies, Integer> {

    @Query(value = "SELECT * from replies  where commentsId =?1", nativeQuery = true)
    public ArrayList<Replies> getRepliesBy(int commentId);


}