package com.itwill.jdbcp;

public interface OracleJdbcp {
	
	
	String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // localhost

	// 오라클 데이터베이스에 접속할 수 있는 계정 이름
	String USER = "scott";

	// 오라클 데이터베이스에 접속할 때 사용할 비밀번호
	String PASSWORD = "tiger";
}
