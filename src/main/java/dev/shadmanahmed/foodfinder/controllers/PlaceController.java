package dev.shadmanahmed.foodfinder.controllers;

import dev.shadmanahmed.foodfinder.model.Place;
import dev.shadmanahmed.foodfinder.model.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PlaceController {

    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @GetMapping("/places")
    public Iterable<Place> getPlaces() {
        return placeRepository.findAll();
    }

    @DeleteMapping("/places/{id}")
    void deletePlace(@PathVariable String id) {
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
