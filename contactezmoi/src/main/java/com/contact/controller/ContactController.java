package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping
    public List<Contact> getAllContact() {
        return  contactRepository.findAll();
    }
	
	@GetMapping("/{Id}")
	public Contact getContactById(@PathVariable int Id) {
        return  contactRepository.findById(Id);
    }
	
	@PostMapping
	public Contact createContact(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@PutMapping("/{Id}")
	public Contact updateContact(@PathVariable int Id,@RequestBody Contact contact) {
		contact.setId(Id);
		return contactRepository.save(contact);
	}
	
	@DeleteMapping("/{Id}")
	public void deleteContact(@PathVariable int Id) {
		contactRepository.deleteById(Id);
	}
}
