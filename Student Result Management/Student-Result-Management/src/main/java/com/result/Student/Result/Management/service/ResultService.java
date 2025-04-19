package com.result.Student.Result.Management.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.result.Student.Result.Management.model.Result;
import com.result.Student.Result.Management.model.ResultRepository;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository repository;

    public List<Result> getAllResults() {
        return repository.findAll();
    }

    public void addResult(Result result) {
        repository.save(result);
    }
}
