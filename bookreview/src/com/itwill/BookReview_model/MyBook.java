package com.itwill.BookReview_model;

import java.time.LocalDateTime;

public class MyBook {

	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언
		public static final String TBL_MYBOOK = "MYBOOK";

		// 데이터베이스 BLOGS 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_ISBN = "ISBN";
		public static final String COL_TITLE = "TITLE";
		public static final String COL_WRITER = "WRITER";
		public static final String COL_PUBLISHER = "PUBLISHER";
		public static final String COL_BOOKREVIEW = "BOOKREVIEW";
		public static final String COL_CATEGORY = "CATEGORY";
		public static final String COL_CREATED_TIME = "CREATE_TIME";
		public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";
	}

	private int isbn;
	private String title;
	private String writer;
	private String category;
	private String publisher;
	private String bookreview;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;

	public MyBook() {
	}

	public MyBook(int isbn, String title, String writer, String publisher, String bookreview,
			String category, LocalDateTime createdTime, LocalDateTime modifiedTime) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.bookreview = bookreview;
		this.category = category;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookreview() {
		return bookreview;
	}

	public void setBookreview(String bookreview) {
		this.bookreview = bookreview;
	}


	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "MyBook [isbn=" + isbn + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", bookreview=" + bookreview + ", favorite=" + ", category=" + category + ", score="
			    + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}

}
