package com.alp_b.practice.petsitter.service;

import com.alp_b.practice.petsitter.dto.CreatePetSitterRequest;
import com.alp_b.practice.petsitter.dto.PetSitterDetailResponse;
import com.alp_b.practice.petsitter.dto.PetSitterPreviewResponse;

import java.util.List;

public interface PetSitterService {
    void createPetSitterRequest(CreatePetSitterRequest createPetSitterRequest);
    List<PetSitterPreviewResponse> findPetSittersByLocation(String location);
    PetSitterDetailResponse findPetSitterDetail(Long petSitterId);
    void deletePetSitter(Long petSitterId);
}
