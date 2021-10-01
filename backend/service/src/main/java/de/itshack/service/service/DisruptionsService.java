package de.itshack.service.service;

import de.itshack.service.model.Disruption;
import de.itshack.service.model.NewDisruption;
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

    public List<Disruption> getDisruptions(List<Double> areaFrom, List<Double> areaTo) {
        return new ArrayList<>();
    }
    public URI createDisruption(NewDisruption newDisruption) throws URISyntaxException {
        return new URI("http://test");
    }
}
