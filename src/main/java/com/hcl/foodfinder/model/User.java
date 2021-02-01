package com.hcl.foodfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;


@Data
@Component
public class User {
    @Id
    private String id;

    private String userName;

    private String password;

    private String email;

}
