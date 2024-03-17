package com.example.Usersservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Check if null
    @Column(name = "first_name")
    private String firstName;
    //Check if null
    @Column(name = "last_name")
    private String lastName;
    //Check if null & validate email & unique
    @Column(name = "email")
    private String email;

    private List<Long> tasksId = new ArrayList<>();

}
