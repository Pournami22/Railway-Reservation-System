package com.example.trainbooking.repository;

import com.example.trainbooking.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}

