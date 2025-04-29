package com.example.Hotel_Booking_System.dto;

public class LoginResponseDto {
    private Long userId;
    private String name;
    private String role;
    private String message;
	
    public LoginResponseDto(){}
    
	public LoginResponseDto(Long userId, String name, String role, String message) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    // Constructor, Getters and Setters
}

