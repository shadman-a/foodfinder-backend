package com.hcl.foodfinder.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "place")
@Entity
@Data
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address;

    private String yelpid;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
