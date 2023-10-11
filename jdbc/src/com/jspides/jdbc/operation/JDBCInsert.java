package com.jspides.jdbc.operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JDBCInsert {
	
	private static Connection connection ;
	private static Statement statement ;
	private static Driver driver ;
	private static String query ;

	public static void main(String[] args) {
		
		try {
			// open connection between java app and DBMS app
			connection = openConnection();
			
			// create statement
			statement = connection.createStatement();
			
			// create statement
			query = "insert into student values(2,'Soham', 'soham@gmail.com',22,40000)" ;
			
			// execute query
			int row = statement.executeUpdate(query);
			System.out.println(row + " rows are affected.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection openConnection() throws SQLException {
		// register driver 
		driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
	}
	
	private static void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(statement != null) {
			statement.close();
		}
		
		DriverManager.deregisterDriver(driver);
	}
}
