package com.itwill.class05;

public class ClassMain05 {

	public static void main(String[] args) {
		// TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
		Subject subj = new Subject(80, 50, 75, 60);
		
		Student stu = new Student(01, "히어로", subj);
				
		stu.inf();
		
	}

}
