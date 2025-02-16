package com.alp_b.practice.petsitter.service.impl;

import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.NotFoundException;
import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.repository.MemberRepository;
import com.alp_b.practice.pet.domain.PetClassification;
import com.alp_b.practice.pet.repository.PetClassificationRepository;
import com.alp_b.practice.petsitter.domain.*;
import com.alp_b.practice.petsitter.dto.CreatePetSitterRequest;
import com.alp_b.practice.petsitter.repository.*;
import com.alp_b.practice.petsitter.service.PetSitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PetSitterServiceImpl implements PetSitterService {
    private final PetSitterRepository petSitterRepository;
    private final MemberRepository memberRepository;
    private final PetClassificationRepository petClassificationRepository;
    private final PossiblePetTypeRepository possiblePetTypeRepository;
    private final DayOfTheWeekRepository dayOfTheWeekRepository;
    private final PossibleDayRepository possibleDayRepository;
    private final PetServiceRepository petServiceRepository;
    private final ProvidingServiceRepository providingServiceRepository;

    private static final String STR_SEPARATER = ", ";

    @Override
    public void createPetSitterRequest(CreatePetSitterRequest createPetSitterRequest) {
        Optional<Member> member = memberRepository.findById(createPetSitterRequest.memberId());

        if (member.isEmpty()) {
            throw new NotFoundException(ErrorCode.MEMBER_NOT_FOUND);
        }

        PetSitter petSitter = PetSitter.builder()
                .id(createPetSitterRequest.memberId())
                .member(member.get())
                .address(createPetSitterRequest.address())
                .startTime(createPetSitterRequest.startTime())
                .endTime(createPetSitterRequest.endTime())
                .pricePerHour(createPetSitterRequest.pricePerHour())
                .build();

        petSitterRepository.save(petSitter);

        List<String> petTypes = List.of(createPetSitterRequest.possiblePetTypes().split(STR_SEPARATER));
        List<String> days = List.of(createPetSitterRequest.possibleDays().split(STR_SEPARATER));
        List<String> services = List.of(createPetSitterRequest.providingServices().split(STR_SEPARATER));

        for (String petType : petTypes) {
            Optional<PetClassification> petClassification = petClassificationRepository.findById(Integer.parseInt(petType));

            if (petClassification.isEmpty()) {
                throw new NotFoundException(ErrorCode.PET_CLASSIFICATION_NOT_FOUND);
            }

            PossiblePetType possiblePetType = PossiblePetType.builder()
                    .petSitter(petSitter)
                    .petClassification(petClassification.get())
                    .build();

            possiblePetTypeRepository.save(possiblePetType);
        }

        for (String day : days) {
            Optional<DayOfTheWeek> dayOfTheWeek = dayOfTheWeekRepository.findById(Integer.parseInt(day));

            if (dayOfTheWeek.isEmpty()) {
                throw new NotFoundException(ErrorCode.DAY_NOT_FOUND);
            }

            PossibleDay possibleDay = PossibleDay.builder()
                    .petSitter(petSitter)
                    .dayOfTheWeek(dayOfTheWeek.get())
                    .build();

            possibleDayRepository.save(possibleDay);
        }

        for (String service : services) {
            Optional<PetService> petService = petServiceRepository.findById(Integer.parseInt(service));

            if (petService.isEmpty()) {
                throw new NotFoundException(ErrorCode.SERVICE_NOT_FOUND);
            }

            ProvidingService providingService = ProvidingService.builder()
                    .petSitter(petSitter)
                    .petService(petService.get())
                    .build();

            providingServiceRepository.save(providingService);
        }
    }

}
