package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain02 {

	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance(); // 다형성

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");

		ContactMain02 app = new ContactMain02();

		boolean run = true;
		while (run) {
			int menu = app.showMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByindex(); 
				break;
			default:
				System.out.println("메뉴 번호(0~4)를 확인하세요.");
			}

		}

		System.out.println(">>> 프로그램 종료 >>>");

	}

	private void updateContactByindex() {
		System.out.println("\n--- 연락처 수정 ---");

		System.out.print("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if (!((ContactDaoImpl) dao).isValidIndex(index)) {
			System.out.println("저장된 인덱스가 없습니다.");
			return;
		}

		Contact contact = dao.read(index);
		System.out.println("수정 전: " + contact);

		System.out.println("이름 수정>> ");
		String name = scanner.nextLine();

		System.out.println("전화번호 수정>> ");
		String phone = scanner.nextLine();

		System.out.println("이메일 수정>> ");
		String email = scanner.nextLine();

		Contact updated = new Contact(name, phone, email);
		int result = dao.update(index, updated);
        if (result == 1) {
            System.out.println(">>> 연락처 수정 성공");
        } else {
            System.out.println(">>> 연락처 수정 실패");
        }
	}

	private void readContactByIndex() {
		System.out.println("\n--- 연락처 검색 ---");
		
		System.out.print("검색할 연락처 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		Contact contact = dao.read(index);
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("해당 인덱스에는 연락처가 없습니다.");
		}

	}

	private void readAllContacts() {
		 System.out.println("\n--- 연락처 목록 ---");
	        Contact[] contact = dao.read(); 
	        int index = 0;
	        for (Contact c : contact) {
	            System.out.println("[" + index + "] " + c);
	            index++;
	        }
	}

	private void saveNewContact() {
		System.out.println("\n--- 새 연락처 저장 ---");

		ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
		if (daoImpl.isMemoryFull()) {
			System.out.println("저장 공간이 부족합니다.");
			return; // 메서드 종료
		}

		System.out.print("아이디 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);

		 int result = dao.create(contact);
	        if (result == 1) {
	            System.out.println("연락처 저장 성공");
	        } else {
	            System.out.println("연락처 저장 실패");
	        }
	}

	private int showMainMenu() {
		System.out.println("\n------------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스 검색 [4]수정");
		System.out.println("\n------------------------------------------------");
		System.out.print("선택> ");
		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

	private int inputInteger() {
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("입력값은 정수여야 합니다.");
                System.out.print("정수 입력>> ");
            }
        }
        
        return result;
    }
}
