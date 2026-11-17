
package com.example.tourist.service;

import org.springframework.stereotype.Service;

import com.example.tourist.entity.Tourist;
import com.example.tourist.repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository repository;

    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public Tourist updateTourist(Long id, Tourist updated) {

        Tourist tourist = repository.findById(id)
                .orElseThrow(() ->
                new RuntimeException("Tourist not found"));

        tourist.setVisitedDestination(
                updated.getVisitedDestination());

        tourist.setContact(updated.getContact());

        return repository.save(tourist);
    }
}
