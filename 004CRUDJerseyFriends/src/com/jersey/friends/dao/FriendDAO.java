package com.jersey.friends.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class FriendDAO {
	Connection conn=null;
	Statement stat=null;
	PreparedStatement ps=null;
	int rs;
	
	public FriendDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/frienddb","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stat=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*public void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql:://localhost:3306/frienddb","root","");
		stat=conn.createStatement();
	
	}*/
	public void deleteFrndfromdb(int id) throws SQLException{
		rs=stat.executeUpdate("delete from frienddb.friend where id="+id);
		
	}

}
