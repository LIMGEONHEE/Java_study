package com.itwill.library_controller;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.itwill.library_model.Library;

import oracle.jdbc.OracleDriver;


import static com.itwill.jdbcp.OracleJdbcp.*;
import static com.itwill.library_model.Library.Entity.*;

//MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
//CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class LibraryDao {

	//-----> singleton
    private static LibraryDao instance = null;
	
    
    private LibraryDao() {
        try {
            // Oracle 드라이버(라이브러리)를 등록.
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static LibraryDao getInstance() {
        if (instance == null) {
            instance = new LibraryDao();
        }
        
        return instance;
    }
    //<----- singleton
    
 // 아이디(PK)로 검색하기:
    private static final String SQL_SELECT_BY_ID = String.format(
            "select * from %s where %s = ?", 
            TBL_LIBRARY, COL_ID);
	
    /**
     * LIBRARY 테이블의 고유키 id를 전달받아서, 해당 Library 객체를 리턴.
     * @param id 검색하기 위한 고유키.
     * @return 테이블에서 검색한 Library 객체. 고유키에 해당하는 행이 없는 경우 null을 리턴.
     */
    public Library read(int id) {
        Library library = null;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(5, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                library = makeBlogFromResultSet(rs);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(conn, stmt, rs);
        }
        
        return library;
    }
    
    /**
     * CRUD 메서드들에서 사용했던 리소스들을 해제.
     * @param conn Connection 객체
     * @param stmt Statement 객체
     * @param rs ResultSet 객체
     */
    private void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
    	try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
    
 // ResultSet에서 각 컬럼의 값들을 읽어서 Library 타입 객체를 생성하고 리턴.
	private Library makeBlogFromResultSet(ResultSet rs) throws SQLException {
		String title = rs.getString(COL_TITLE);
		String img_path = rs.getString(COL_IMG_PATH);
		String writer = rs.getString(COL_WRITER);
		String publisher = rs.getString(COL_PUBLISHER);
		int id = rs.getInt(COL_ID);
		String categorie = rs.getString(COL_CATEGORIE);
		String location = rs.getString(COL_LOCATION);
		String loan_availability = rs.getString(COL_LOAN_AVAILABILITY);
		
		Library library = new Library(title, img_path, writer, publisher, id, categorie, location, loan_availability);
		return library;
	}
	
	private static final String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = systimestamp where %s = ?", 
            TBL_LIBRARY, COL_TITLE, COL_IMG_PATH, COL_WRITER, COL_PUBLISHER, COL_CATEGORIE, COL_LOCATION, COL_LOAN_AVAILABILITY,COL_ID);
}
