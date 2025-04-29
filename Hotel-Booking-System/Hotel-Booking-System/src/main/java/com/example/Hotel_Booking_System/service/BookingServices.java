package com.example.Hotel_Booking_System.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Hotel_Booking_System.dto.BookingDto;
import com.example.Hotel_Booking_System.entity.Booking;
import com.example.Hotel_Booking_System.entity.Room;
import com.example.Hotel_Booking_System.repository.BookingRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServices {

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private com.example.Hotel_Booking_System.repository.RoomRepository roomRepository;


    public Booking makeBooking(Booking booking) {
        Optional<Room> roomOpt = roomRepository.findById(booking.getRoomId());
        if (roomOpt.isEmpty()) {
            throw new IllegalArgumentException("Room not found for ID: " + booking.getRoomId());
        }

        Room room = roomOpt.get();

        long days = java.time.temporal.ChronoUnit.DAYS.between(
                booking.getCheckInDate(), booking.getCheckOutDate());

        if (days <= 0) {
            throw new IllegalArgumentException("Invalid check-in/check-out dates.");
        }

        double totalPrice = room.getPricePerNight() * days;
        booking.setTotalPrice(totalPrice);

        return bookingRepository.save(booking);
    }



    public List<BookingDto> getAllBooking() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    private BookingDto convertToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUserId());
        dto.setRoomId(booking.getRoomId());
        dto.setCheckInDate(booking.getCheckInDate());
        dto.setCheckOutDate(booking.getCheckOutDate());
        return dto;
    }
}
	
