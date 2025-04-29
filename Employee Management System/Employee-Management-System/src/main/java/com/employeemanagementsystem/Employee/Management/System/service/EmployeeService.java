package com.employeemanagementsystem.Employee.Management.System.service;

import java.util.List;

import com.employeemanagementsystem.Employee.Management.System.enity.EmployeeEntity;

public interface EmployeeService {
	
	public EmployeeEntity createEmp(EmployeeEntity emp);
	
	public List<EmployeeEntity> getAllEmployee();
	
	public EmployeeEntity getEmpByID(int id);
	
	public EmployeeEntity updateEmployee(int id);
	
	public void deleteEmployee(int id);
 
}
