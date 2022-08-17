package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    @GetMapping("/welcome")
    public ResponseEntity<ResponseDTO> welcomeToAddressBook(){
        ResponseDTO responseDTO = new ResponseDTO("Welcome to address book");
        return ResponseEntity.ok().body(responseDTO);
    }
}
