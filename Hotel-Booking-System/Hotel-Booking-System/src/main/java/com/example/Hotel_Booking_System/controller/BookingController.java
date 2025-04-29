package com.example.Hotel_Booking_System.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Booking_System.dto.BookingDto;
import com.example.Hotel_Booking_System.entity.Booking;
import com.example.Hotel_Booking_System.service.BookingServices;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingServices bookingService;

    @PostMapping("/make")
    public Booking makeBooking(@RequestBody Booking booking) {
        return bookingService.makeBooking(booking);
    }

    @GetMapping("/getall")
    public List<BookingDto> getAllBookings() {
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public Optional<Booking> getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable Long id) {
        bookingService.cancelBooking(id);
        return "Booking cancelled successfully!";
    }
}
