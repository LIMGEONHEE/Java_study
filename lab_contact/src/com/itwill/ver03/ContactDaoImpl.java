package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;
import com.itwill.ver03.ContactDaoImpl;

public class ContactDaoImpl implements ContactDao {

	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {
	}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}

	private List<Contact> contacts = new ArrayList<>();
	

	@Override
	public int create(Contact contact) {
		contacts.add(contact);
		return 1;
		}


	@Override
	public List<Contact> read() {

		return contacts;
	}

	@Override
	public Contact read(int index) {
		return contacts.get(index);
	}

	@Override
	public int update(int index, Contact contact) {
		contacts.set(index, contact);
		return 1;
	}

	@Override
	public int delete(int index) {
		contacts.remove(index);
		return 1;
	}

	

}

