package com.classproject.classprojectbackend.service;

import com.classproject.classprojectbackend.Repositories.InqueringAboutRepository;
import com.classproject.classprojectbackend.Repositories.QuestionRepository;
import com.classproject.classprojectbackend.entity.InqueringAbout;
import com.classproject.classprojectbackend.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class QuestionService {

    @Autowired(required=true)
    public QuestionRepository questionRepository;

    @Autowired(required=true)
    public InqueringAboutRepository inqueringAbout;

    public Question saveQuestion(Question question){

        return  questionRepository.save(question);
    }

    public ArrayList<InqueringAbout> getInquringAbout(){

        return  (ArrayList<InqueringAbout>)inqueringAbout.findAll();
    }

    public ArrayList<Question> getQuestions(){

        return  (ArrayList<Question>)questionRepository.findAll();
    }


}
