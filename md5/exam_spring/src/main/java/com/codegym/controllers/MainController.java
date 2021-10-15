package com.codegym.controllers;

import com.codegym.models.entity.CarStation;
import com.codegym.models.services.CarStationService;
import com.codegym.models.services.CarTypeService;
import com.codegym.models.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// crossOgrigin them vao de update khong bi loi, loi~ khong cho update
// nham giup cho phep chia se giu lieu
@CrossOrigin(origins = "*")
@RestController

// bat buoc phai co api, api interface
@RequestMapping("/api/car-station")
public class MainController {
    @Autowired
    private CarStationService carStationService;
    @Autowired
    private CarTypeService carTypeService;


    @GetMapping(value = "/list")
    public ResponseEntity<Page<CarStation>> showList(@PageableDefault(value = 2) Pageable pageable) {
        Page<CarStation> carStationsList = carStationService.findAll(pageable);
        if (carStationsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carStationsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarStation> findById(@PathVariable(value = "id") Long id) {
        CarStation carStation = this.carStationService.findById(id);
        if (carStation == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carStation, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> remove(@PathVariable(value = "id") Long id) {
        this.carStationService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CarStation> createCarStation(@RequestBody CarStation carStation){
        CarStation newCarStation = this.carStationService.save(carStation);
        return new ResponseEntity<>(carStation,HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<CarStation> editCarStation(@RequestBody CarStation carStation){
        CarStation editedCarStation = this.carStationService.save(carStation);
        return new ResponseEntity<>(editedCarStation,HttpStatus.OK);
    }


}
