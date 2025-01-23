package com.korit.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC(Java Database Connectivity)
// JAVA에서 데이터베이스 연결을 위한 표준 API

// 특징
// - 플랫폼 독립적: 운영체제와 상관없이 사용 가능
// - 표준화: 특정 DBMS에 종속되지 않고 공통으로 사용할 수 있음
// - 확장성: DBMS에 따라 서로 다른 JDBC를 사용하여 확장 가능
// - 상호작용성: SQL 쿼리를 실행하고 결과를 처리할 수 있음
// - 유연성: 다양한 DBMS를 지원

public class MySQLConnector {
	
	public static MySQLConnector instance = null;
	public Connection connection; 
	
	private final String URL = "jdbc:mysql://127.0.0.1:3306/crud";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	private MySQLConnector() {
		try {
			// JDBC MySQL 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLConnector getInstance() {
		if(instance == null) {
			// synchronized: 비동기 처리(멀티 스레드)에 대해 동기 처리가 가능하게 함
			synchronized(MySQLConnector.class) {
				if(instance == null) {
					instance = new MySQLConnector();
				}
			}
		}
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
