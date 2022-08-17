package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Storing in Database
@Repository
public interface AddressBookRepository extends JpaRepository<Contact,Integer> {
}
