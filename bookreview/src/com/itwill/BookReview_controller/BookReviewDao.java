package com.itwill.BookReview_controller;

import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;


//MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
//CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class BookReviewDao {

	//-----> singleton
    private static BookReviewDao instance = null;
	
    
    private BookReviewDao() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static BookReviewDao getInstance() {
        if (instance == null) {
            instance = new BookReviewDao();
        }
        
        return instance;
    }
    //<----- singleton
}
