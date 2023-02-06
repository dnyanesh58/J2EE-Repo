package com.app.service;

import java.util.List;

import com.app.pojos.Contact;

public interface IContactSevice 
{
	List<Contact> getAllContacts();
	
	Contact saveNewContact(Contact newContact);
	
	String removeContact(Long id);
	
	Contact updateContact(Contact updatedDetachedContact);
	
	Contact getContactDetails(Long id);
}
