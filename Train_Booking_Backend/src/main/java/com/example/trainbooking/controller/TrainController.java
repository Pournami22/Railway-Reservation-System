package com.example.trainbooking.controller;

import com.example.trainbooking.model.Train;
import com.example.trainbooking.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable Long id) {
        Train train = trainService.getTrainById(id);
        if (train != null) {
            return ResponseEntity.ok(train);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return trainService.saveTrain(train);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrain(@PathVariable Long id) {
        trainService.deleteTrain(id);
        return ResponseEntity.noContent().build();
    }
}

