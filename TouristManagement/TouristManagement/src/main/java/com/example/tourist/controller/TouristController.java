
package com.example.tourist.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.tourist.entity.Tourist;
import com.example.tourist.service.TouristService;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;

    public TouristController(TouristService service) {
        this.service = service;
    }

    // Pre-generated token
    private static final String VALID_TOKEN = "abc123";

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTourist(

            @PathVariable Long id,

            @RequestHeader(value = "Token", required = false)
            String token,

            @RequestBody Tourist updated) {

        // Validate token
        if (!VALID_TOKEN.equals(token)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Invalid Token");
        }

        // Update tourist record
        try {
            Tourist result = service.updateTourist(id, updated);

            return ResponseEntity.ok(
                    "Tourist Updated Successfully: "
                    + result.getName());

        } catch (RuntimeException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
