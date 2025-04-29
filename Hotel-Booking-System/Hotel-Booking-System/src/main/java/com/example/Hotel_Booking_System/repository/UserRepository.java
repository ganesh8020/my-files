package com.example.Hotel_Booking_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel_Booking_System.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

}
