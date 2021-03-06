package com.hcl.foodfinder;

import com.hcl.foodfinder.model.PlaceRepository;
import com.hcl.foodfinder.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    private PlaceRepository repositoryPlace;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        repository.deleteAll();
//
//        // save a couple of customers
//        repository.save(new User());
//
//        repositoryPlace.save(new Place());

    }
}
