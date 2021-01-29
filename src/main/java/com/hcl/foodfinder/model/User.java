package com.hcl.foodfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class User {
    @Id
    private String id;

    private String userName;

    private String password;

}
