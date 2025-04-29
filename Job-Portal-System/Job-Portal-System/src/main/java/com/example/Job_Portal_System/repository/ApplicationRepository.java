package com.example.Job_Portal_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Job_Portal_System.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

}
