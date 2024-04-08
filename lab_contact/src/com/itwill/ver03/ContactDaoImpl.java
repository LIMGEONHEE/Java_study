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

	public boolean isMemoryFull() {
		return (count ==);
	}
	private List<Contact> contacts = new ArrayList<>();
	private int count = 0;

	@Override
	public int create(Contact contact) {
		if (isMemoryFull()) {
			return 0;
		}

		return 1;
	}

	@Override
	public List<Contact> read() {

		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) {
			return index;
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index) && contact != null) {
			return 1;
		} else {
			return 0;
		}
		
	}

	@Override
	public int delete(int index) {
		
		return 0;
	}


}
