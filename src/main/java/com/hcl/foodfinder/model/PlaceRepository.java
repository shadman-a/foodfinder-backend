package com.hcl.foodfinder.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "places", path = "places")
public interface PlaceRepository extends MongoRepository<Place, String> {

    List<Place> findAllByName(@Param("name") String name);
}
