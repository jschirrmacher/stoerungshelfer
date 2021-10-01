package de.itshack.service.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import de.itshack.service.model.Disruption;
import de.itshack.service.model.NewDisruption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.itshack.service.api.DisruptionsApi;
import org.springframework.web.context.request.NativeWebRequest;

@RestController
public class DisruptionsController implements DisruptionsApi {

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return DisruptionsApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<Disruption>> getDisruptions(List<Double> areaFrom, List<Double> areaTo) {
        return DisruptionsApi.super.getDisruptions(areaFrom, areaTo);
    }

    @Override
    public ResponseEntity<List<Disruption>> newDisruption(NewDisruption newDisruption) {
        return DisruptionsApi.super.newDisruption(newDisruption);
    }
}
