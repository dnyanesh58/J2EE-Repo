package com.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ContactCrudRepo;
import com.app.pojos.Contact;

import custom_exception.ResourceNotFoundException;

@Service
@Transactional
public class ContactServiceImpl implements IContactSevice
{
	
	@Autowired
	private ContactCrudRepo contactRepo;

	@Override
	public List<Contact> getAllContacts() 
	{
		return contactRepo.findAll();
	}

	@Override
	public Contact saveNewContact(Contact newContact)
	{
		return contactRepo.save(newContact);
	}

	@Override
	public String removeContact(Long id) 
	{
		String mesg = "Deletion Failed";
		if (contactRepo.existsById(id)) 
		{
			contactRepo.deleteById(id);
			mesg = "Contact deleted with id : "+id;
		}
		return mesg;
	}

	@Override
	public Contact updateContact(Contact updatedDetachedContact) 
	{
		return contactRepo.save(updatedDetachedContact);
	}

	@Override
	public Contact getContactDetails(Long id) 
	{
		return contactRepo.findById(id).orElseThrow(() -> new
				ResourceNotFoundException("Invalid contact id !!!! "+id));
	}
}
