package com.result.Student.Result.Management.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.result.Student.Result.Management.model.Result;
import com.result.Student.Result.Management.service.ResultService;

import java.util.List;

@RestController
@RequestMapping("/results")
@CrossOrigin("*")
public class ResultController {

    @Autowired
    private ResultService service;

    @GetMapping("/getall")
    public List<Result> getResults() {
        return service.getAllResults();
    }

    @PostMapping("/addresult")
    public String addResult(@RequestBody Result result) {
        service.addResult(result);
        return "Result added successfully!";
    }
}
