package com.hcl.foodfinder.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    List<Place> findAllByName(@Param("name") String name);
}
