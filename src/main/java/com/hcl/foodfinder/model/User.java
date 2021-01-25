package com.hcl.foodfinder.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "user", schema = "public")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Place> places;

}
