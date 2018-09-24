package com.evan.database;

import java.sql.*;


public class EvanDatabase {

////	public static void main(String[] args) 
//	{
//		try 
//		{
//			Class.forName("com.mysql.cj.jdbc."
//					+ "Driver");
//			String url="jdbc:mysql://localhost/EMP?useSSL=false";
//			Connection Con=DriverManager.getConnection(url,"root","");
//			String sql="select * from Employees";
//			PreparedStatement st=Con.prepareStatement(sql);
//			
//			ResultSet rs=st.executeQuery();
//			
//			while(rs.next())
//			{
//				int id  = rs.getInt("id");
//			       int age = rs.getInt("age");
//			       String first = rs.getString("first");
//			       String last = rs.getString("last");
//
//			       //Display values
//			       System.out.print("ID: " + id);
//			       System.out.print(", Age: " + age);
//			       System.out.print(", First: " + first);
//			       System.out.println(", Last: " + last);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
public ResultSet get() throws ClassNotFoundException, SQLException
{
try 
{
	Class.forName("com.mysql.cj.jdbc."
			+ "Driver");
	String url="jdbc:mysql://localhost/EMP?useSSL=false";
	Connection Con=DriverManager.getConnection(url,"root","");
	String sql="select id,age,first,last from Employees";
	PreparedStatement st=Con.prepareStatement(sql);
	
	ResultSet rs=st.executeQuery();
	
	return rs;
	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw e;
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	throw e;
}

}
}
