package com.employe.EmployeeDetails;

public class Employee {
	
	private int id;
	private String name;
	private char grade;
	public Employee(int id, String name, char grade) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	

}
