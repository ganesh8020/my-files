package com.studentcourse.Student.Course.Registration.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentcourse.Student.Course.Registration.entity.Course;
import com.studentcourse.Student.Course.Registration.entity.Student;
import com.studentcourse.Student.Course.Registration.repository.RegistrationRepository;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository repo;

    public List<Student> getStudents() {
        return repo.getAllStudents();
    }

    public List<Course> getCourses() {
        return repo.getAllCourses();
    }

    public void register(int studentId, int courseId) {
        repo.registerStudentToCourse(studentId, courseId);
    }
}
