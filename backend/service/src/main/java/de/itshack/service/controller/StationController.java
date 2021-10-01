package de.itshack.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.itshack.service.api.StationsApi;
import de.itshack.service.model.Station;

@RestController
public class StationController implements StationsApi {
  @Override
  public ResponseEntity<List<Station>> getStations(@Valid Integer minimumAvailableBikes) {
    return ResponseEntity.ok(List.of(new Station().availableBikesQuantity(2).id(42).name("Matrix")));
  }
}
