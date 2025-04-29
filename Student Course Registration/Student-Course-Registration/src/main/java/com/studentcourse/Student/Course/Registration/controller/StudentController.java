package com.studentcourse.Student.Course.Registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.studentcourse.Student.Course.Registration.entity.Course;
import com.studentcourse.Student.Course.Registration.entity.RegistrationRequest;
import com.studentcourse.Student.Course.Registration.entity.Student;
import com.studentcourse.Student.Course.Registration.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private RegistrationService service;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getStudents();
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return service.getCourses();
    }

    @PostMapping("/register")
    public String registerStudent(@RequestBody RegistrationRequest request) {
        service.register(request.getStudentId(), request.getCourseId());
        return "Student registered to course!";
    }

}

