package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Contact;
import com.app.service.IContactSevice;

@RestController
@RequestMapping("/api/contacts")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController 
{
	
	@Autowired
	private IContactSevice conserv;
	
	public ContactController()
	{
		System.out.println("in ctor of : "+getClass());
	}
	
	@GetMapping
	public List<Contact> getAllContacts()
	{
		System.out.println("In all contacts ");
		return conserv.getAllContacts();
	}
	
	@PostMapping
	public Contact addNewContact(@RequestBody Contact newContact)
	{
		System.out.println("In Save Contact "+newContact);
		return conserv.saveNewContact(newContact);
	}
	
	@DeleteMapping("/{id}")
	public String deleteContact(@PathVariable Long id)
	{
		System.out.println("In delete contact");
		return conserv.removeContact(id);
	}
	
	@GetMapping("/{id}")
	public Contact getContactById(@PathVariable Long id)
	{
		System.out.println("in contactbyid ");
		return conserv.getContactDetails(id);
	}
	
	@PutMapping
	public Contact updateContact(@RequestBody Contact existContact)
	{
		System.out.println("in update contact");
		return conserv.updateContact(existContact);
	}
}
