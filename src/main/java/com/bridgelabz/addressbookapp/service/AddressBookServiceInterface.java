package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.entity.Contact;
import com.bridgelabz.addressbookapp.exception.AddressNotFound;

import java.util.List;

public interface AddressBookServiceInterface {
    List<Contact> getContacts();
    Contact getContactById(int id) throws AddressNotFound;
    Contact addContacts(ContactDTO contact);
    Contact editContacts(int id,ContactDTO contactDTO);
    String deleteContacts(int id);
}
