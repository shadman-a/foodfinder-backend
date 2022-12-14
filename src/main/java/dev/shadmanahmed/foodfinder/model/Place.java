package dev.shadmanahmed.foodfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Place {

    @Id
    private String id;

    private String name;

    private String address;

    private String yelpid;

    private String user;
}
