package com.evan.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	public StudentDao()
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
		String sql = "update employees set id=?,first=?,last=?, age=? where id=120";
		st = Con.prepareStatement(sql);
	}

	public void insertstudent(student s) throws ClassNotFoundException, SQLException {
		try {
			String sql= "insert into student(studentname,roll,grade)values(?,?,?)";
			PreparedStatement st = Con.prepareStatement(sql);
			st.setString(1, s.studentname);
			st.setString(2, s.roll);
			st.setString(3,s.grade);			
			int result = st.executeUpdate();

			System.out.println(String.valueOf(result));
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

}
/*class student
{
	public int studentid;
	public String studentname;
	public String roll;
	public String grade;
}*/
