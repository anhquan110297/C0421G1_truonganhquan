package com.codegym.controllers;

import com.codegym.models.entity.CarStation;
import com.codegym.models.entity.Garage;
import com.codegym.models.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/garage")
public class GarageRestController {

    @Autowired
    private GarageService garageService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Garage>> showList (){
        List <Garage> garageList = garageService.findAll();
        if (garageList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(garageList,HttpStatus.OK);
    }
}
