package com.example.Hotel_Booking_System.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Booking_System.dto.RoomDto;
import com.example.Hotel_Booking_System.entity.Room;
import com.example.Hotel_Booking_System.service.RoomService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
@CrossOrigin(origins = "*")  // Allow all origins (for development only)
public class RoomController {
    



    @Autowired
    private RoomService roomService;

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("/getall")
    public List<RoomDto> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/room/{id}") // for single room{
    public Optional<RoomDto> getRoomById(@PathVariable Long id){
    return roomService.getRoomById(id);
    }
    
   
    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PutMapping("/availability/{id}")
    public Room updateRoomAvailability(@PathVariable Long id, @RequestParam boolean available) {
        return roomService.updateRoomAvailability(id, available);
    }
}

