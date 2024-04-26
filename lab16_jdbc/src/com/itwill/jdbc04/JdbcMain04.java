package com.itwill.jdbc04;

import static com.itwill.jdbc.OracleJdbc.PASSWORD;
import static com.itwill.jdbc.OracleJdbc.URL;
import static com.itwill.jdbc.OracleJdbc.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		
		// 오라클 드라이버를 등록
		DriverManager.registerDriver(new OracleDriver());
				
		// 오라클 DB 접속
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				
		final String sql = "delete from blogs where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		 stmt.setInt(1, 1);
		
		int result = stmt.executeUpdate();
		System.out.print(result + "개 행이 삭제 됨.");
		
		stmt.close();
		conn.close();
					
	}

}
