package com.example.Hotel_Booking_System.dto;


public class UserDto {
    private Long id;
    private String password;
    private String name;
    private String email;
    private String Role;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return Role;
	}
	public void setPhone(String role) {
		this.Role = Role;
	}

}

