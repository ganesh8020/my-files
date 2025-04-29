package com.example.Hotel_Booking_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hotel_Booking_System.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

	List<Room> findByAvailable(boolean b);

}
