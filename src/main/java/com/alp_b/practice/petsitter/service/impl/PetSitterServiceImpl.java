package com.alp_b.practice.petsitter.service.impl;

import com.alp_b.practice.codeGroup.domain.CodeGroup;
import com.alp_b.practice.codeGroup.repository.CodeGroupRepository;
import com.alp_b.practice.common.exception.ErrorCode;
import com.alp_b.practice.common.exception.custom.NotFoundException;
import com.alp_b.practice.member.domain.Member;
import com.alp_b.practice.member.repository.MemberRepository;
import com.alp_b.practice.petsitter.domain.*;
import com.alp_b.practice.petsitter.dto.*;
import com.alp_b.practice.petsitter.repository.*;
import com.alp_b.practice.petsitter.service.PetSitterService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PetSitterServiceImpl implements PetSitterService {
    private final PetSitterRepository petSitterRepository;
    private final MemberRepository memberRepository;
    private final CodeGroupRepository codeGroupRepository;
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
            Optional<CodeGroup> codeGroup = codeGroupRepository.findById(Integer.parseInt(petType));

            if (codeGroup.isEmpty()) {
                throw new NotFoundException(ErrorCode.CODE_GROUP_NOT_FOUND);
            }

            PossiblePetType possiblePetType = PossiblePetType.builder()
                    .petSitter(petSitter)
                    .codeGroup(codeGroup.get())
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

    @Override
    @Transactional(readOnly = true)
    public List<PetSitterPreviewResponse> findPetSittersByLocation(String location) {
        List<Tuple> petSitters =  petSitterRepository.findByLocation(location);

        return petSitters.stream()
                .map(tuple -> {
                    return PetSitterPreviewResponse.of(
                            tuple.get(0, Long.class),
                            tuple.get(1, String.class),
                            tuple.get(2, String.class),
                            tuple.get(3, Integer.class));
                })
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PetSitterDetailResponse findPetSitterDetail(Long petSitterId) {
        Tuple petSitterDetail = petSitterRepository.findDetailById(petSitterId);

        List<CodeGroup> possiblePetTypes = possiblePetTypeRepository.findAllPossiblePetTypeByPetSitterId(petSitterId);
        List<PossiblePetTypeResponse> possiblePetTypeResponses = new ArrayList<>();

        for (CodeGroup possiblePetType : possiblePetTypes) {
            possiblePetTypeResponses.add(PossiblePetTypeResponse.from(possiblePetType));
        }

        List<DayOfTheWeek> possibleDays = possibleDayRepository.findAllDayOfTheWeekByPetSitterId(petSitterId);
        List<PossibleDayResponse> possibleDayResponses = new ArrayList<>();

        for (DayOfTheWeek possibleDay : possibleDays) {
            possibleDayResponses.add(PossibleDayResponse.from(possibleDay));
        }

        List<PetService> providingServices = providingServiceRepository.findAllPetServiceByPetSitterId(petSitterId);
        List<ProvidingServiceResponse> providingServiceResponses = new ArrayList<>();

        for (PetService providingService : providingServices) {
            providingServiceResponses.add(ProvidingServiceResponse.from(providingService));
        }

        return PetSitterDetailResponse.of(
                petSitterDetail.get(0, Long.class),
                petSitterDetail.get(1, String.class),
                petSitterDetail.get(2, String.class),
                petSitterDetail.get(3, String.class),
                petSitterDetail.get(4, String.class),
                petSitterDetail.get(5, LocalTime.class),
                petSitterDetail.get(6, LocalTime.class),
                petSitterDetail.get(7, Integer.class),
                possiblePetTypeResponses,
                possibleDayResponses,
                providingServiceResponses
        );
    }

    @Override
    public void updatePetSitter(Long petSitterId, UpdatePetSitterRequest updatePetSitterRequest) {
        PetSitter petSitter = petSitterRepository.findById(petSitterId)
                .orElseThrow(() -> new NotFoundException(ErrorCode.PET_SITTER_NOT_FOUND));

        if (updatePetSitterRequest.address() != null) petSitter.setAddress(updatePetSitterRequest.address());
        if (updatePetSitterRequest.startTime() != null) petSitter.setStartTime(updatePetSitterRequest.startTime());
        if (updatePetSitterRequest.endTime() != null) petSitter.setEndTime(updatePetSitterRequest.endTime());
        if (updatePetSitterRequest.pricePerHour() != null) petSitter.setPricePerHour(updatePetSitterRequest.pricePerHour());

        petSitterRepository.save(petSitter);
    }

    @Override
    public void deletePetSitter(Long petSitterId) {
        Optional<PetSitter> petSitter = petSitterRepository.findById(petSitterId);

        if (petSitter.isEmpty()) {
            throw new NotFoundException(ErrorCode.PET_SITTER_NOT_FOUND);
        }

        petSitterRepository.delete(petSitter.get());
    }

}
