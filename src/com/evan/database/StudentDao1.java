package com.evan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao1 {
	public StudentDao1()
	{
		try {
			getconnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String driver = "com.mysql.cj.jdbc.Driver";
	public Connection Con = null;
	public PreparedStatement st;
	public String url = "jdbc:mysql://localhost/school?useSSL=false";

	public void getconnection() throws SQLException {
		try {
			Class.forName(driver);

			Con = DriverManager.getConnection(url, "root", "");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ResultSet getsingle(int id)
	{
		 PreparedStatement stmt = null;
		  String sql = "SELECT studentid,studentname FROM student where studentid=?";
		  ResultSet rs=null;
		  
		 
		  try {
			stmt=Con.prepareStatement(sql);
			stmt.setInt(1, id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return rs;
	}
	public ResultSet getStudents() throws SQLException {
		ResultSet rs=null;
		try {
			String sql= "select * from student";
			PreparedStatement st = Con.prepareStatement(sql);
			rs = st.executeQuery();

			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	
	

	public int insertstudent(student s) throws ClassNotFoundException, SQLException {
		
		int result=0;
		try {
			String sql= "insert into student(studentname)values(?)";
			PreparedStatement st = Con.prepareStatement(sql);
			st.setString(1, s.studentname);
					
			result = st.executeUpdate();

			System.out.println(String.valueOf(result));
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return result;

	}
	public int SaveData(int id, String name) {
		 PreparedStatement stmt = null;
		  String sql = "update student set studentname=? where studentid=?";
		  int rs=0;
		  
		 
		  try {
			stmt=Con.prepareStatement(sql);
			stmt.setInt(2, id);
			stmt.setString(1, name);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		rs = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     return rs;
		
	}

}

