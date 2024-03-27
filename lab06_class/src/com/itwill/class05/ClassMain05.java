package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		
		// 기본생성자 사용해서 Subject 타입의 객체 생성
		Subject subj1 = new Subject();
		
//		System.out.println("국어: " + subj.korean);
//		System.out.println("영어: " + subj.english);
//		System.out.println("수학: " + subj.math);
//		System.out.println("과학: " + subj.science);
//		System.out.println("총점: " + subj.total());
//		System.out.println("평균: " + subj.ave());
		
		// 아규먼트를 갖는 생성자를 사용해서 Subject 타입의 객체를 생성
		Subject subj2 = new Subject(56, 98, 79, 83);
		subj2.info();
		
		// 아규먼트를 갖는 생성자를 사용해서 Student 타입의 객체를 생성
		Student stu1 = new Student(01, "히어로", subj2);
		stu1.info();
		
		// 기본 생성자를 사용해서 Student 타입의 객체를 생성
		Student stu2 = new Student();
		stu2.info();
		
	}

}
