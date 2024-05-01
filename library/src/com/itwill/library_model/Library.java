package com.itwill.library_model;

public class Library {

	public static final class Entity {
		// 데이터베이스 테이블 이름을 상수로 선언

		public static final String TBL_LIBRARY = "LIBRARY";

		// 데이터베이스 LIBRARY 테이블의 컬럼 이름들을 상수로 선언.
		public static final String COL_TITLE = "TITLE";
		public static final String COL_IMG_PATH = "IMG_PATH";
		public static final String COL_WRITER = "WRITER";
		public static final String COL_PUBLISHER = "PUBLISHER";
		public static final String COL_ID = "ID";
		public static final String COL_CATEGORIE = "CATEGORIE";
		public static final String COL_LOCATION = "LOCATION";
		public static final String COL_LOAN_AVAILABILITY = "LOAN_AVAILABILITY";
	}
	
	private String title;
	private String img_path;
	private String writer;
	private String publisher;
	private int id;
	private String categorie;
	private String location;
	private String loan_availability;
	
	public Library() {}
	
	public Library(String title, String img_path, String writer, String publisher, int id, String categorie, String location, String loan_availability) {
		super();
		this.title = title;
		this.img_path = img_path;
		this.writer = writer;
		this.publisher = publisher;
		this.id = id;
		this.categorie = categorie;
		this.location = location;
		this.loan_availability = loan_availability;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg_path() {
		return img_path;
	}

	public void setImg_path(String img_path) {
		this.img_path = img_path;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLoan_availability() {
		return loan_availability;
	}

	public void setLoan_availability(String loan_availability) {
		this.loan_availability = loan_availability;
	}
	
	@Override
	public String toString() {
		return "Library [title=" + title + ", img_path=" + img_path + ", writer=" + writer + ", publisher=" + publisher
				+ ", id=" + id + ", categorie=" + categorie + ", location=" + location + ", loan_availability="
				+ loan_availability + "]";
	}
	
}