package com.codegym.controllers;

import com.codegym.models.entity.CarType;
import com.codegym.models.entity.Garage;
import com.codegym.models.services.CarTypeService;
import com.codegym.models.services.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/car-type")
public class CarTypeRestController {

    @Autowired
    private CarTypeService carTypeService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<CarType>> showList (){
        List <CarType> carTypeList = carTypeService.findAll();
        if (carTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carTypeList,HttpStatus.OK);
    }
}
