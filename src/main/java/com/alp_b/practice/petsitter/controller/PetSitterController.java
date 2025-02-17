package com.alp_b.practice.petsitter.controller;

import com.alp_b.practice.petsitter.dto.CreatePetSitterRequest;
import com.alp_b.practice.petsitter.dto.PetSitterDetailResponse;
import com.alp_b.practice.petsitter.dto.PetSitterListResponse;
import com.alp_b.practice.petsitter.dto.PetSitterPreviewResponse;
import com.alp_b.practice.petsitter.service.PetSitterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pet-sitters")
public class PetSitterController {
    private final PetSitterService petSitterService;

    private static final String DEFAULT_LOCATION = "서울";

    @PostMapping
    public ResponseEntity<String> createPetSitterRequest(
            @RequestBody @Valid CreatePetSitterRequest createPetSitterRequest
            ) {
        petSitterService.createPetSitterRequest(createPetSitterRequest);

        return ResponseEntity.ok("PetSitter created");
    }

    @GetMapping
    public ResponseEntity<PetSitterListResponse> findPetSitters(
            @RequestParam(required = false, defaultValue=DEFAULT_LOCATION) String location
    ) {
        List<PetSitterPreviewResponse> petSitters = petSitterService.findPetSittersByLocation(location);

        return ResponseEntity.ok(new PetSitterListResponse(petSitters));
    }

    @GetMapping("/{petSitterId}")
    public ResponseEntity<PetSitterDetailResponse> findPetSitterDetail(@PathVariable Long petSitterId) {
        PetSitterDetailResponse petSitterDetailResponse = petSitterService.findPetSitterDetail(petSitterId);

        return ResponseEntity.ok(petSitterDetailResponse);
    }

    @DeleteMapping("/{petSitterId}")
    public ResponseEntity<String> deletePetSitter(@PathVariable Long petSitterId) {
        petSitterService.deletePetSitter(petSitterId);

        return ResponseEntity.ok("PetSitter is deleted successfully.");
    }
}
