package com.hcl.foodfinder.model;

import lombok.Data;

@Data
public class Email {
    private String to_address;
    private String subject;
    private String body;
}
