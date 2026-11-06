package org.example.controller;

import org.example.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class ContactController {

    private final Map<Long, Contact> contacts = new HashMap<>();

    private Long nextId = 1L;

    @GetMapping("/contacts")
    public Map<Long, Contact> getAllContacts() {
        return contacts;
    }


    @GetMapping("/contact/{contactId}")
    public Contact getContactById(@PathVariable Long contactId) {
        return contacts.get(contactId);
    }

    @PostMapping("/contacts")
    public Contact createContact(@RequestBody Contact contact) {
        contact.setId(nextId);
        contacts.put(nextId, contact);
        nextId++;
        return contact;
    }


    @PutMapping("/contacts/{contactId}")
    public ResponseEntity<Contact> updateContact(
            @PathVariable Long contactId,
            @RequestBody Contact updatedContact) {

        if (!contacts.containsKey(contactId)) {
            return ResponseEntity.notFound().build();
        }

        updatedContact.setId(contactId);
        contacts.put(contactId, updatedContact);

        return ResponseEntity.ok(updatedContact);
    }



}