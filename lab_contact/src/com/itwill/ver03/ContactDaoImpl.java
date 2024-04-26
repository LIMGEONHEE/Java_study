package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;
import com.itwill.ver03.ContactDaoImpl;

//controller 클래스
public class ContactDaoImpl implements ContactDao {
	// ----- singleton
	private static ContactDaoImpl instance = null;

	private ContactDaoImpl() {
	}

	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	//----- singleton
	
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
		if (isValidIndex(index)) {
			return contacts.get(index);
		} else {
			return null;
		}

	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)) {
			contacts.set(index, contact);
//			contacts.get(index).setName(contact.getName());
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index);
			return 1;
		} else {
			return 0;
		}
	}

	public boolean isValidIndex(int index) {
		return (index < contacts.size() && index >= 0);
	}

}
