package com.alp_b.practice.petsitter.controller;

import com.alp_b.practice.petsitter.dto.CreatePetSitterRequest;
import com.alp_b.practice.petsitter.service.PetSitterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pet-sitters")
public class PetSitterController {
    private final PetSitterService petSitterService;

    @PostMapping
    public ResponseEntity<String> createPetSitterRequest(
            @RequestBody @Valid CreatePetSitterRequest createPetSitterRequest
            ) {
        petSitterService.createPetSitterRequest(createPetSitterRequest);

        return ResponseEntity.ok("PetSitter created");
    }
}
