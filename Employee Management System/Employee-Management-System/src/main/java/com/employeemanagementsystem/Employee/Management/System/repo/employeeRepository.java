package com.employeemanagementsystem.Employee.Management.System.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementsystem.Employee.Management.System.enity.EmployeeEntity;

public interface employeeRepository extends JpaRepository<EmployeeEntity, Integer> {

}
