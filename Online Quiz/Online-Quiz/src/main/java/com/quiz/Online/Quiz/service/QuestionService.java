package com.quiz.Online.Quiz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private com.quiz.Online.Quiz.repository.QuestionRepository repository;

    public List<com.quiz.Online.Quiz.model.Question> getAllQuestions() {
        return repository.findAll();
    }
}

