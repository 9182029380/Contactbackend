package com.example.ContactPage.service;

import com.example.ContactPage.model.Contact;
import com.example.ContactPage.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContactService {
     @Autowired
     private ContactRepository contactRepository;

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> createContact(List<Contact> contact) {
        return contactRepository.saveAll(contact);
    }

    public Contact getContactById(int id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> getContact() {
        return contactRepository.findAll();
    }

    public Contact updateContact(Contact contact) {
        Contact oldContact=null;
        Optional<Contact> optionalcontact=contactRepository.findById(contact.getId());
        if(optionalcontact.isPresent()) {
            oldContact=optionalcontact.get();
            oldContact.setName(contact.getName());
            oldContact.setCity(contact.getCity());
            oldContact.setEmail(contact.getEmail());
            oldContact.setPhone(contact.getPhone());
            oldContact.setZipcode(contact.getZipcode());

            contactRepository.save(oldContact);
        }else {
            return new Contact();
        }
        return oldContact;
    }

    public String deleteContactById(int id) {
        contactRepository.deleteById(id);
        return "Contact got deleted";
    }



}
