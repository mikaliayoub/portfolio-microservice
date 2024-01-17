package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:3000/")
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
