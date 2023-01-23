package com.incedo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDemo {

	public static void main(String[] args) {
		try {
//			1. Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			2. Get Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/incedo_db", "root", "rootroot");
			
			
			// 3. Fire statement
//			Statement stmt = con.createStatement();
			PreparedStatement stmt = con.prepareStatement("insert into employees values(?,?,?)");
			stmt.setInt(1, 35);
			stmt.setString(2, "Abcd");
			stmt.setDouble(3, 34343.34);
			
			int records = stmt.executeUpdate();
			System.out.println("Inserted records: "+ records);
			
//			4. Get result
			ResultSet rs = stmt.executeQuery("SELECT * FROM employees;");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			
//			5. Close connection
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
