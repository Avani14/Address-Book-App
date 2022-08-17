package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.entity.Contact;
import com.bridgelabz.addressbookapp.exception.AddressNotFound;
import com.bridgelabz.addressbookapp.service.AddressBookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address-book")
public class AddressBookController {
    @Autowired
    private AddressBookServiceInterface addressBookServiceInterface;
    @GetMapping("/welcome")
    public ResponseEntity<ResponseDTO> welcomeToAddressBook(){
        ResponseDTO responseDTO = new ResponseDTO("Welcome to address book");
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/get-contacts")
    public ResponseEntity<ResponseDTO> getAllContacts(){
        List<Contact> list = addressBookServiceInterface.getContacts();
        ResponseDTO responseDTO = new ResponseDTO("All the contacts are",list);
        return  ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/get-contact/{id}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable int id) throws AddressNotFound {
        Contact contact = addressBookServiceInterface.getContactById(id);
        ResponseDTO responseDTO = new ResponseDTO(" Contact with id "+id,contact);
        return  ResponseEntity.ok().body(responseDTO);
    }
    @PostMapping("/add-contact")
    public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contactDTO){
        Contact contact = addressBookServiceInterface.addContacts(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO(" Contact added successfully ",contact);
        return  ResponseEntity.ok().body(responseDTO);
    }
    @PutMapping("/edit-contact/{id}")
    public ResponseEntity<ResponseDTO> editContact(@PathVariable int id,@RequestBody ContactDTO contactDTO){
        Contact contact = addressBookServiceInterface.editContacts(id,contactDTO);
        if(contact == null){
            return ResponseEntity.ok().body(new ResponseDTO("Unable to find the contact with id "+id,contact));
        }
        ResponseDTO responseDTO = new ResponseDTO(" Contact edited successfully ",contact);
        return  ResponseEntity.ok().body(responseDTO);
    }
    @DeleteMapping("/delete-contact/{id}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable int id){
        String res = addressBookServiceInterface.deleteContacts(id);
        ResponseDTO responseDTO = new ResponseDTO(" Contact deleted successfully ",res);
        return  ResponseEntity.ok().body(responseDTO);
    }
}
