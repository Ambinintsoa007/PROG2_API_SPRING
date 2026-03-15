package com.hotel.demo_booking.service;

import com.hotel.demo_booking.model.Booking;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    List<Booking> bookings = new ArrayList<>();

    public List<Booking> getAll() {
        return bookings;
    }

    public List<Booking> add(Booking booking) {
        if (booking.roomNumber < 1 || booking.roomNumber > 9) {
            throw new IllegalArgumentException("Room numbers are only between 1 and 9");
        }

        for (Booking b : bookings) {
            if (b.roomNumber == booking.roomNumber && b.date.equals(booking.date)) {
                throw new RuntimeException("Room is not available on " + booking.date);
            }
        }

        bookings.add(booking);
        return bookings;
    }
}