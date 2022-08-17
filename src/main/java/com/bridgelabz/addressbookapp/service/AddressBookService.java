package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.entity.Contact;
import com.bridgelabz.addressbookapp.exception.AddressNotFound;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class AddressBookService implements AddressBookServiceInterface{
    @Autowired
    private AddressBookRepository addressBookRepository;

    @Override
    public List<Contact> getContacts() {
        return addressBookRepository.findAll();
    }

    @Override
    public Contact getContactById(int id) throws AddressNotFound {
       Contact contact = addressBookRepository.findById(id).orElse(null);
       if(contact == null){
           throw new AddressNotFound("Contact with id "+id +" not found");
       }
       return contact;
    }

    @Override
    public Contact editContacts(int id,ContactDTO contactDTO) {
        Contact contact = addressBookRepository.findById(id).orElse(null);
        Contact contact1 = new Contact(contactDTO);
        contact.setFirstName(contact1.getFirstName());
        contact.setLastName(contact1.getLastName());
        contact.setAddress(contact1.getAddress()) ;
        contact.setCity(contact1.getCity());
        contact.setState(contact1.getState());
        contact.setZipNo(contact1.getZipNo());
        contact.setMobileNo(contact1.getMobileNo()) ;
        contact.setEmailId(contact1.getEmailId());
        contact.setPassword(contact1.getPassword()) ;
        return addressBookRepository.save(contact);
    }

    @Override
    public String deleteContacts(int id) {
        if(addressBookRepository.findById(id) == null){
            return "Contact with id :"+id+" not found.";
        }
        addressBookRepository.deleteById(id);
        return "Deleted successfully.";
    }

    @Override
    public Contact addContacts(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO);
        return  addressBookRepository.save(contact);
    }
}
