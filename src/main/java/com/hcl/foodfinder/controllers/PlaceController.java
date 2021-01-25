package com.hcl.foodfinder.controllers;

import com.hcl.foodfinder.model.Place;
import com.hcl.foodfinder.model.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PlaceController {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/places")
    public Iterable<Place> getCurrencies() {
        return placeRepository.findAll();
    }

    @DeleteMapping("/places/{id}")
    void deletePlace(@PathVariable Long id) {
        placeRepository.deleteById(id);
    }

    @PostMapping("/places")
    void addPlace(@RequestBody Place place) {
        placeRepository.save(place);
    }

    @PutMapping("/places")
    void updatePlace(@RequestBody Place place) {
        placeRepository.save(place);
    }
}
