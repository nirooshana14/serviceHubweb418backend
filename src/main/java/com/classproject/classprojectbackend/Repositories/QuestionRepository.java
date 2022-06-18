package com.classproject.classprojectbackend.Repositories;

import com.classproject.classprojectbackend.entity.PostRequirement;
import com.classproject.classprojectbackend.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,Integer> {
}
