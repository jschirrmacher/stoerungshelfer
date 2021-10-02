package de.itshack.service.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import de.itshack.service.entity.DisruptionEntity;
import de.itshack.service.model.Disruption;
import de.itshack.service.model.NewDisruption;
import de.itshack.service.service.DisruptionsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.itshack.service.api.DisruptionsApi;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DisruptionsController implements DisruptionsApi {
    @NonNull
    private DisruptionsService disruptionsService;

    @Override
    public ResponseEntity<Disruption> disruptionsIdDelete(UUID id) {
        return DisruptionsApi.super.disruptionsIdDelete(id);
    }

    @Override
    public ResponseEntity<List<Disruption>> getDisruptions(List<Double> areaFrom, List<Double> areaTo, List<String> include) {
        List<Disruption> disruptions = disruptionsService.getDisruptions(areaFrom, areaTo, include).stream().map(DisruptionEntity::toModel).toList();
        return ResponseEntity.ok(disruptions);
    }

    @Override
    public ResponseEntity<Disruption> newDisruption(NewDisruption newDisruption) {
        return ResponseEntity.ok(disruptionsService.createDisruption(newDisruption).toModel());
    }
}
