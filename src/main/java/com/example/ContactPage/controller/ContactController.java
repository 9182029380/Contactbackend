package com.example.ContactPage.controller;

import com.example.ContactPage.model.Contact;
import com.example.ContactPage.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {
    @Autowired
    private ContactService contactService;



    @PostMapping()
    public Contact addContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @PostMapping("/addContact")
    public List<Contact> addConatct(@RequestBody List<Contact> contact) {
        return contactService.createContact(contact);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return contactService.getContactById(id);
    }

    @GetMapping("/contact")
    public List<Contact> getAllContact() {
        return contactService.getContact();
    }

    @PutMapping("/updateContact")
    public Contact updateContact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/contact/{id}")
    public String deleteContact(@PathVariable int id) {
        return contactService.deleteContactById(id);
    }


}
