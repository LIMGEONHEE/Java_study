package com.itwill.modifier03;

public class Member {
	// field
	private String memberId; // 읽기 전용 필드
	private String memberPassword; // 읽기/쓰기 필드

	// constructor
	public Member(String memberId, String memberPassword) { // 다른 패키지에 있더라도 생성자는 불러야하기 때문에 public으로 사용
		if (memberId != null && memberPassword != null) {
			this.memberId = memberId;
			this.memberPassword = memberPassword;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// method
	// getter 메서드
	public String getMemberId() {
		return this.memberId;
	}

	public String getMemberPassword() {
		return this.memberPassword;
	}

	// setter 메서드
	public void setMemberPassword(String password) {
		if (password != null) {
			this.memberPassword = password;
		}
	}

}