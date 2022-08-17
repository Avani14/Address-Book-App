package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.entity.Contact;

import java.util.List;

public interface AddressBookServiceInterface {
    List<Contact> getContacts();
    Contact addContacts(ContactDTO contact);
    String editContacts(int id,ContactDTO contactDTO);
    String deleteContacts(int id);
}
