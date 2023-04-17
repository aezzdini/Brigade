package com.example.Brigade.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor  @NoArgsConstructor

public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String lastname;
    private String firstname;
    private String email;
    private long addressId;
}
