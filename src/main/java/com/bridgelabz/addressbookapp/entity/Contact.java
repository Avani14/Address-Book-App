package com.bridgelabz.addressbookapp.entity;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue
    private int personId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipNo;
    private String mobileNo;
    private String emailId;
    private String password;

    public Contact(ContactDTO contactDTO) {
        this.firstName =contactDTO.getFirstName();
        this.lastName =contactDTO.getLastName();
        this.address =contactDTO.getAddress();
        this.city =contactDTO.getCity();
        this.state =contactDTO.getState();
        this.zipNo =contactDTO.getZipNo();
        this.mobileNo =contactDTO.getMobileNo();
        this.emailId =contactDTO.getEmailId();
        this.password = contactDTO.getPassword();
    }
}
