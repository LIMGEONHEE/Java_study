package com.itwill.BookReview_model;

import java.time.LocalDateTime;

public class WishBook {

	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언
		public static final String TBL_WISHBOOK = "WISHBOOK";

		// 데이터베이스 BLOGS 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_TITLE = "TITLE";
		public static final String COL_WRITER = "WRITER";
		public static final String COL_PUBLISHER = "PUBLISHER";
		public static final String COL_MEMO = "MEMO";
		public static final String COL_CATEGORY = "CATEGORY";
		public static final String COL_CREATED_TIME = "CREATE_TIME";
		public static final String COL_MODIFIED_TIME = "MODIFIED_TIME";

	}
	
	private String title;
	private String writer;
	private String category;
	private String publisher;
	private String memo;
	private LocalDateTime createdTime;
	private LocalDateTime modifiedTime;
	
	public WishBook() {}
	
	public WishBook(String title, String writer, String publisher, String memo,
			String category, LocalDateTime createdTime, LocalDateTime modifiedTime) {
		super();
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.memo = memo;
		this.category = category;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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
		return "WishBook [title=" + title + ", writer=" + writer + ", category=" + category + ", publisher=" + publisher
				+ ", memo=" + memo + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}

}