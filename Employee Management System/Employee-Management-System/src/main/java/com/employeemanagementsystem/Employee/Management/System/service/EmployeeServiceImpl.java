package com.employeemanagementsystem.Employee.Management.System.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.grammars.hql.HqlParser.IsEmptyPredicateContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.Employee.Management.System.enity.EmployeeEntity;
import com.employeemanagementsystem.Employee.Management.System.repo.employeeRepository;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	employeeRepository emprepo;

	@Override
	public EmployeeEntity createEmp(EmployeeEntity emp) {

		EmployeeEntity employee=emprepo.save(emp);
		return employee;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity> employee=emprepo.findAll();
		return employee;
	}

	@Override
	public EmployeeEntity getEmpByID(int id) {

	Optional<EmployeeEntity> employee=emprepo.findById(id);
	
	return employee.get();
	}
		

	@Override
	public EmployeeEntity updateEmployee(int id) {
		Optional<EmployeeEntity> employee=emprepo.findById(id);
		return employee.get();
	}

	@Override
	public void deleteEmployee(int id) {
		emprepo.deleteById(id);

		
	}

}
