package edu.mum.mpp.zayagerman.dao;

import java.util.List;

import edu.mum.mpp.zayagerman.contact.Contact;

public interface ContactDAO {
	public void addContact(Contact contact);
    public void deleteContact(int contactId);
    public void updateContact(Contact contact);
    public List<Contact> getAllContacts();
    public Contact getContactById(int contactId);
}
