package com.example.ContactPage.repo;

import com.example.ContactPage.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository  extends JpaRepository<Contact,Integer> {


}
