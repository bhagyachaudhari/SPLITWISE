package com.example.splitwise.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
public class User extends BaseModel{

    private String name;
    private String password;
    private String phoneNumber;
}
