package com.brokul.cateringonline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 10)
    @Column(unique = true)
    private String username;


    private String password;

    @Email
    private String email;

    private String firstName;
    private String lastName;
    private String postalCode;
    private String city;
    private String address;
    private String phoneNumber;


    @OneToMany
    private List<Catering> listOfUserOrders;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();


}
