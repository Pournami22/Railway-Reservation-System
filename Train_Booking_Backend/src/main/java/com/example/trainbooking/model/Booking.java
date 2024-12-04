package com.example.trainbooking.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Train train;

    private String passengerName;
    private String passengerEmail;
    private LocalDate bookingDate;
    private int numberOfSeats;

    // Getters and setters
    // Constructor
}

