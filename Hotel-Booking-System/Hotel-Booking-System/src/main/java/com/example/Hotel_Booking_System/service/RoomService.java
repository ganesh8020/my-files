package com.example.Hotel_Booking_System.service;

import com.example.Hotel_Booking_System.dto.RoomDto;
import com.example.Hotel_Booking_System.entity.Room;
import com.example.Hotel_Booking_System.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<RoomDto> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<RoomDto> getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(this::convertToDto);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }

    public Room updateRoomAvailability(Long id, boolean available) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        room.setAvailable(available);
        return roomRepository.save(room);
    }

    private RoomDto convertToDto(Room room) {
        RoomDto dto = new RoomDto();
        dto.setRoomId(room.getRoomId());  // Set roomId
        dto.setRoomType(room.getRoomType());
        dto.setPricePerNight(room.getPricePerNight());
        dto.setAvailable(room.isAvailable());
        return dto;
    }
}
