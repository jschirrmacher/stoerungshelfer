package de.itshack.service.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
    public ResponseEntity<List<Disruption>> getDisruptions(List<Double> areaFrom, List<Double> areaTo) {
        return ResponseEntity.ok(disruptionsService.getDisruptions(areaFrom, areaTo));
    }

    @Override
    public ResponseEntity<List<Disruption>> newDisruption(NewDisruption newDisruption) {
        try {
            return ResponseEntity.created(disruptionsService.createDisruption(newDisruption));
        } catch (URISyntaxException ex) {
            return ResponseEntity.status(500);
        }
    }
}
