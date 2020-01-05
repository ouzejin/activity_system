package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/activity", "root","root");//2
			//stat = conn.createStatement(); //3
			//rs = stat.executeQuery("select * from membership"); //4
			prep = conn.prepareStatement("insert into membership values(?,?,?,?)");
			prep.setString(1, "m06");
			prep.setString(2, "lisi06");
			prep.setString(3, "lisi06");
			prep.setInt(4, 2);
			prep.addBatch();
			prep.setString(1, "m07");
			prep.setString(2, "lisi07");
			prep.setString(3, "lisi07");
			prep.setInt(4, 2);
			prep.addBatch();
			prep.setString(1, "m08");
			prep.setString(2, "lisi08");
			prep.setString(3, "lisi08");
			prep.setInt(4, 2);
			prep.addBatch();
			int[] a= prep.executeBatch();
			for(int b:a)
				System.out.println(b);
							
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		catch (SQLException e) {

				e.printStackTrace();
			}finally {
				try {
					if(rs!=null)
						rs.close();
					if(prep!=null)
						prep.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}

	}

}
