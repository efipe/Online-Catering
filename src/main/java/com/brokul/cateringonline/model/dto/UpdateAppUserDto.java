package com.brokul.cateringonline.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateAppUserDto {

    private String password;
    private String passwordConfirm;
    @Email
    private String email;

    private String firstName;
    private String lastName;
    private String postalCode;
    private String city;
    private String address;
    private String phoneNumber;

}
