package com.hotel.demo_booking.controller;

import com.hotel.demo_booking.model.Booking;
import com.hotel.demo_booking.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    BookingService bookingService = new BookingService();

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Booking booking) {
        try {
            return ResponseEntity.ok(bookingService.add(booking));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
}