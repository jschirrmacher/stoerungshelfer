package de.itshack.service.service;

import de.itshack.service.entity.DisruptionEntity;
import de.itshack.service.model.Disruption;
import de.itshack.service.model.NewDisruption;
import de.itshack.service.repository.DisruptionsRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DisruptionsService {

    @NonNull DisruptionsRepository disruptionsRepository;

    public List<DisruptionEntity> getDisruptions(List<Double> areaFrom, List<Double> areaTo, List<String> include) {
        return disruptionsRepository.findAll();
    }
    public DisruptionEntity createDisruption(NewDisruption newDisruption) {
        return disruptionsRepository.save(new DisruptionEntity(newDisruption));
    }
}
