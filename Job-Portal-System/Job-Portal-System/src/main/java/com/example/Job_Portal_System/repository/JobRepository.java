package com.example.Job_Portal_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Job_Portal_System.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
