package com.employe.EmployeeDetails;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@GetMapping("/emp")
	public Employee getEmpoyee() {
		return new Employee (2,"Suri",'A');
	}
		
		@GetMapping("/list") 
		public List<Employee>geEmployeList(){
			
			List<Employee> emplist=new ArrayList<>();
			emplist.add(new Employee(3,"prabhu",'B'));
			return emplist;
	}
}
