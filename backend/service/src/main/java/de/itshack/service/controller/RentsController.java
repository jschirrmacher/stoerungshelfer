package de.itshack.service.controller;

import java.util.List;

import javax.validation.Valid;

import de.itshack.service.model.Rent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import de.itshack.service.api.RentsApi;

@RestController
public class RentsController implements RentsApi {
  @Override
  public ResponseEntity<Void> deleteRent(Integer rentId) {
    return RentsApi.super.deleteRent(rentId);
  }

  @Override
  public ResponseEntity<Rent> getRent(Integer rentId) {
    // TODO Auto-generated method stub
    return RentsApi.super.getRent(rentId);
  }

  @Override
  public ResponseEntity<List<Rent>> getRents() {
    // TODO Auto-generated method stub
    return RentsApi.super.getRents();
  }

  @Override
  public ResponseEntity<Void> postRents(@Valid Rent rent) {
    // TODO Auto-generated method stub
    return RentsApi.super.postRents(rent);
  }

  @Override
  public ResponseEntity<Void> putRent(Integer rentId, @Valid Rent rent) {
    // TODO Auto-generated method stub
    return RentsApi.super.putRent(rentId, rent);
  }
}
