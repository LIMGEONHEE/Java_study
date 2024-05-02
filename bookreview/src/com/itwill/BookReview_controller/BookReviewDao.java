package com.itwill.BookReview_controller;

import static com.itwill.BookReviewJdbc.BookReviewJdbc.PASSWORD;
import static com.itwill.BookReviewJdbc.BookReviewJdbc.URL;
import static com.itwill.BookReviewJdbc.BookReviewJdbc.USER;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.BookReview_model.MyBook;
import com.itwill.BookReview_model.*;

import oracle.jdbc.OracleDriver;
import static com.itwill.BookReview_model.MyBook.Entity.*;







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
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     */
    private void closeResources(Connection conn, Statement stmt) {
        closeResources(conn, stmt, null);
    }
    
 // ResultSet에서 각 컬럼의 값들을 읽어서 MyBook 타입 객체를 생성하고 리턴.
    private MyBook makeMyBookFromResultSet(ResultSet rs) throws SQLException {
        int isbn = rs.getInt(COL_ISBN);
        String title = rs.getString(COL_TITLE);
        String writer = rs.getString(COL_WRITER);
        String publisher = rs.getString(COL_PUBLISHER);
        String bookreview = rs.getString(COL_BOOKREVIEW);
        String category = rs.getString(COL_CATEGORY);
        LocalDateTime createdTime = rs.getTimestamp(COL_CREATED_TIME)
                .toLocalDateTime();
        LocalDateTime modifiedTime = rs.getTimestamp(COL_MODIFIED_TIME)
                .toLocalDateTime();
        
        MyBook mybook = new MyBook(isbn, title, writer, publisher, bookreview, 
        		 category, createdTime, modifiedTime);
        
        return mybook;
    }
    
 // read() 메서드에서 사용할 SQL 문장: select * from mybook order by isbn desc
    private static final String SQL_SELECT_ALL = String.format(
            "select * from %s order by %s desc", 
            TBL_MYBOOK, COL_ISBN);
    /**
     * 데이터베이스 테이블 MYBOOK 테이블에서 모든 레코드(행)를 검색해서 
     * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
     * 테이블에 행이 없는 경우 빈 리스트를 리턴.
     * @return MyBook을 원소로 갖는 ArrayList.
     */
    public List<MyBook> read() {
        List<MyBook> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 데이터베이스에 접속.
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            // SQL 문장을 데이터베이스로 전송해서 실행.
            rs = stmt.executeQuery();
            // 결과 처리.
            while (rs.next()) {
            	MyBook mybook = makeMyBookFromResultSet(rs);
                result.add(mybook);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result;
    }
    
    
    
    // create(Blog blog) 메서드에서 사용할 SQL:
    // insert into blogs (title, content, writer) values (?, ?, ?)
    private static final String SQL_INSERT = String.format(
            "insert into %s (%s, %s, %s, %s, %s) values ( ?, ?, ?, ?, ?)", 
            TBL_MYBOOK,COL_TITLE, COL_WRITER, COL_PUBLISHER, COL_BOOKREVIEW, COL_CATEGORY);
    
    
    /**
     * 데이터베이스의 MYBOOK 테이블에 행을 삽입.
     * @param MyBook 테이블에 삽입할 제목, 내용, 작성자 정보를 가지고 있는 객체.
     * @return 테이블에 삽입된 행의 개수.
     */
    public int create(MyBook mybook) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속.
            stmt = conn.prepareStatement(SQL_INSERT); // Statement 객체 생성.
            stmt.setString(1, mybook.getTitle());
            stmt.setString(2, mybook.getWriter());
            stmt.setString(3, mybook.getPublisher());
            stmt.setString(4, mybook.getBookreview());
            stmt.setString(5, mybook.getCategory());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
            return result;
        }
    
    
 // delete(int isbn) 메서드에서 사용할 SQL: delete from mybook where isbn = ?
    private static final String SQL_DELETE = String.format(
            "delete from %s where %s = ?", 
            TBL_MYBOOK, COL_ISBN);
    
    /**
     * 테이블 MYBOOK에서 고유키(PK) isbn에 해당하는 레코드(행)를 삭제.
     * @param isbn 삭제하려는 레코드의 고유키.
     * @return 테이블에서 삭제된 행의 개수.
     */
    public int delete(int isbn) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, isbn);
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
    

  
    
 // 제목에 검색 키워드가 포함된 검색 결과:
    // select * from blogs where lower(title) like ? order by id desc
    private static final String SQL_SELECT_BY_TITLE = String.format(
            "select * from %s where lower(%s) like ? order by %s desc", 
            TBL_MYBOOK, COL_TITLE, COL_ISBN);
    
    // 내용에 검색 키워드가 포함된 검색 결과:
    // select * from blogs where lower(writer) like ? order by id desc
    private static final String SQL_SELECT_BY_WRITER = String.format(
            "select * from %s where lower(%s) like ? order by %s desc", 
            TBL_MYBOOK, COL_WRITER, COL_ISBN);
    
    private static final String SQL_SELECT_BY_TITLE_OR_WRITER = String.format(
            "select * from %s " +
            "where lower(%s) like ? or lower(%s) like ? " + 
            "order by %s desc", 
            TBL_MYBOOK, COL_TITLE, COL_WRITER, COL_ISBN);
    
    
    /** 
     * 제목, 내용, 제목 또는 내용, 작성자로 검색하기.
     * 검색 타입과 검색어를 전달받아서, 해당 SQL 문장을 실행하고 그 결과를 리턴.
     * @param type 0 - 제목 검색, 1 - 내용 검색, 2 - 제목 또는 내용 검색, 3 - 작성자 검색.
     * @param keyword 검색 문자열.
     * @return 검색 결과 리스트. 검색 결과가 없으면 빈 리스트.
     */
    public List<MyBook> search(int type, String keyword) {
        List<MyBook> result = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String searchKeyword = "%" + keyword.toLowerCase() + "%"; // like 검색에서 사용할 파라미터
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            switch (type) {
            case 0: // 제목으로 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE);
                stmt.setString(1, searchKeyword);
                break;
            case 1: // 작가으로 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_WRITER);
                stmt.setString(1, searchKeyword);
                break;
            case 2: // 제목 또는 작가으로 검색
                stmt = conn.prepareStatement(SQL_SELECT_BY_TITLE_OR_WRITER);
                stmt.setString(1, searchKeyword);
                stmt.setString(2, searchKeyword);
                break;
              }
            
            rs = stmt.executeQuery();
            while (rs.next()) {
               MyBook mybook = makeMyBookFromResultSet(rs);
                result.add(mybook);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return result;
    }
    
    // 아이디(PK)로 검색하기:
    private static final String SQL_SELECT_BY_ISBN = String.format(
            "select * from %s where %s = ?", 
            TBL_MYBOOK, COL_ISBN);
    /**
     * MYBOOK 테이블의 고유키 isbn를 전달받아서, 해당 MyBook 객체를 리턴.
     * @param isbn 검색하기 위한 고유키.
     * @return 테이블에서 검색한 MyBook 객체. 고유키에 해당하는 행이 없는 경우 null을 리턴.
     */
    public MyBook read(int isbn) {
    	 	MyBook mybook = null;
    	 	
    	 	Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                stmt = conn.prepareStatement(SQL_SELECT_BY_ISBN);
                stmt.setInt(1, isbn);
                rs = stmt.executeQuery();
                if (rs.next()) {
                	mybook = makeMyBookFromResultSet(rs);
                }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeResources(conn, stmt, rs);
    }
            return mybook;
}

    
    private static final String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ? , %s = ?, %s = ?, %s = systimestamp where %s = ?", 
            TBL_MYBOOK, COL_CATEGORY, COL_TITLE, COL_WRITER, COL_PUBLISHER, COL_BOOKREVIEW, COL_CREATED_TIME, COL_ISBN);
    
    /**
     * MYBOOK 테이블 업데이트.
     * @param mybook 업데이트할 id(고유키), 제목, 내용을 가지고 있는 객체.
     * @return 업데이트한 행의 개수.
     */
    public int update(MyBook mybook) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, mybook.getCategory());
            stmt.setString(2, mybook.getTitle());
            stmt.setString(3, mybook.getWriter());
            stmt.setString(4, mybook.getPublisher());
            stmt.setString(5, mybook.getBookreview());
            stmt.setInt(6, mybook.getIsbn());
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt);
        }
        
        return result;
    }
}
