package dev.shadmanahmed.foodfinder;

import dev.shadmanahmed.foodfinder.model.PlaceRepository;
import dev.shadmanahmed.foodfinder.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    private PlaceRepository repositoryPlace;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
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
