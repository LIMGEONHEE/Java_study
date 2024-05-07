package com.itwill.BookReview_model;

import java.time.LocalDateTime;



public class WishBook {

	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언
		public static final String TBL_WISHBOOK = "WISHBOOK";

		// 데이터베이스 BLOGS 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_TITLE1 = "TITLE1";
		public static final String COL_WRITER1 = "WRITER1";
		public static final String COL_CATEGORY1 = "CATEGORY1";
		public static final String COL_PUBLISHER1 = "PUBLISHER1";
		public static final String COL_MEMO = "MEMO";
		public static final String COL_CREATED_TIME1 = "CREATE_TIME1";
		public static final String COL_MODIFIED_TIME1 = "MODIFIED_TIME1";

	}
	
	private String title1;
	private String writer1;
	private String publisher1;
	private String category1;
	private String memo;
	private LocalDateTime createdTime1;
	private LocalDateTime modifiedTime1;
	
	public WishBook() {}
	
	public WishBook(String title1, String writer1, String publisher1, String category1, 
			String memo, LocalDateTime createdTime1, LocalDateTime modifiedTime1) {
		super();
		this.title1 = title1;
		this.writer1 = writer1;
		this.publisher1 = publisher1;
		this.category1 = category1;
		this.memo = memo;
		this.createdTime1 = createdTime1;
		this.modifiedTime1 = modifiedTime1;
		
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getWriter1() {
		return writer1;
	}

	public void setWriter1(String writer1) {
		this.writer1 = writer1;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getPublisher1() {
		return publisher1;
	}

	public void setPublisher1(String publisher1) {
		this.publisher1 = publisher1;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public LocalDateTime getCreatedTime1() {
		return createdTime1;
	}

	public void setCreatedTime1(LocalDateTime createdTime1) {
		this.createdTime1 = createdTime1;
	}

	public LocalDateTime getModifiedTime1() {
		return modifiedTime1;
	}

	public void setModifiedTime1(LocalDateTime modifiedTime1) {
		this.modifiedTime1 = modifiedTime1;
	}

	@Override
	public String toString() {
		return "WishBook [title1=" + title1 + ", writer1=" + writer1 + ", category1=" + category1 + ", publisher1="
				+ publisher1 + ", memo=" + memo + ", createdTime1=" + createdTime1 + ", modifiedTime1=" + modifiedTime1
				+ "]";
	}

}