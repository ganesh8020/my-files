package com.quiz.Online.Quiz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quiz.Online.Quiz.model.Question;
import com.quiz.Online.Quiz.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("/questions")
    public List<Question> getAllQuestions() {
        return service.getAllQuestions();
    }
}
