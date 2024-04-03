package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

// MVC 아키텍쳐에서 뷰(UI: User Interface) 역할을 담당하는 클래스.
public class MemberMain {

	private final Scanner scanner = new Scanner(System.in);
	private MemberDaoImpl dao = MemberDaoImpl.getInstance();
	
	public static void main(String[] args) {
		
	}

}
