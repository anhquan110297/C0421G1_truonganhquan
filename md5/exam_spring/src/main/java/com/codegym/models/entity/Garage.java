package com.codegym.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
public class Garage {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<CarStation> carStationSet;

    public Garage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CarStation> getCarStationSet() {
        return carStationSet;
    }

    public void setCarStationSet(Set<CarStation> carStationSet) {
        this.carStationSet = carStationSet;
    }
}
