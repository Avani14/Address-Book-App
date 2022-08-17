package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class ContactDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Please enter valid first name")
    private String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Please enter valid last name")
    private String lastName;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @Pattern(regexp = "[0-9]{6}",message = "Please enter valid pin code")
    private String zipNo;
    @NotNull
    private String mobileNo;
    @NotNull
    private String emailId;
    @NotNull
    private String password;
}
