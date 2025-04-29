package com.example.Job_Portal_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Job_Portal_System.entity.Application;
import com.example.Job_Portal_System.entity.Job;
import com.example.Job_Portal_System.entity.User;
import com.example.Job_Portal_System.repository.ApplicationRepository;
import com.example.Job_Portal_System.repository.JobRepository;
import com.example.Job_Portal_System.repository.UserRepository;

@Service
public class PortalService {
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private JobRepository jobRepo;
    
    @Autowired
    private ApplicationRepository applicationRepo;

    public User registerUser(User user) {
        return userRepo.save(user);
    }

    public Job postJob(Job job) {
        return jobRepo.save(job);
    }

    public Application applyJob(Long userId, Long jobId, String resumePath) {
        Application app = new Application();
        app.setUserId(userId);
        app.setJobId(jobId);
        app.setResumePath(resumePath);
        return applicationRepo.save(app);
    }

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public List<Application> getAllApplications() {
       return applicationRepo.findAll();
       
    }
}
