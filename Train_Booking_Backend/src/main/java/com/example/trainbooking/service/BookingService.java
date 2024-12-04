package com.example.trainbooking.service;

import com.example.trainbooking.model.Booking;
import com.example.trainbooking.model.Train;
import com.example.trainbooking.repository.BookingRepository;
import com.example.trainbooking.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TrainRepository trainRepository;

    public Booking createBooking(Booking booking) {
        Train train = trainRepository.findById(booking.getTrain().getId()).orElse(null);
        if (train != null && train.getAvailableSeats() >= booking.getNumberOfSeats()) {
            train.setAvailableSeats(train.getAvailableSeats() - booking.getNumberOfSeats());
            trainRepository.save(train);
            return bookingRepository.save(booking);
        }
        return null;
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
}

