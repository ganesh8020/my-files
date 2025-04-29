package com.employeemanagementsystem.Employee.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.Employee.Management.System.enity.EmployeeEntity;
import com.employeemanagementsystem.Employee.Management.System.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService serrepo;
	
	@PostMapping("/create")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee) {
		EmployeeEntity emp=serrepo.createEmp(employee);
		return emp;
	}
	@GetMapping("/getAll")
	public List<EmployeeEntity> getAllEmp() {
		List<EmployeeEntity> emp=serrepo.getAllEmployee();

		return emp ;
		
	}
	 @GetMapping("/getby{id}")
	public EmployeeEntity getByID(@PathVariable int id) {
		EmployeeEntity emp=serrepo.getEmpByID(id);
		return emp;
		
	}
     @PutMapping("/updateby{id}")
	public EmployeeEntity updateEmp(@PathVariable int id) {
    	 EmployeeEntity emp=serrepo.updateEmployee(id);
    	 		return emp;
		
	}
	@DeleteMapping("/deleteby{id}")
	public String deleteEmp(@PathVariable int id) {
		serrepo.deleteEmployee(id);
		return "deleted";
		
		
	}
	
}
		


	

