package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dao.MembershipDAO;
import cn.edu.lingnan.dto.Membership;

public class MembershipTest {

	public static void main(String[] args) {
	
    MembershipDAO m = new MembershipDAO();
//   m.delete("m01");
    System.out.println(m.login("lisi01", "lisi01"));
//    Vector<Membership> v = new Vector<Membership>();
//    v = m.findAllMembership();
//    System.out.println(v.size());
//	
//		Connection conn = null;
//		Statement stat = null;
//		ResultSet rs = null;
//		try {
//			//---1---
//			Class.forName("com.mysql.jdbc.Driver");//1
//
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/activity", "root","root");//2
//			stat = conn.createStatement
//					(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//			//---2---
//			rs = stat.executeQuery("select * from membership ");
//			System.out.println(rs.isBeforeFirst());
//			rs.first();
//			System.out.println(rs.isBeforeFirst());
//			//rs.last();
//			//rs.absolute(4);
//			rs.relative(3);
//			System.out.println(rs.isLast());
//			System.out.println(rs.getString("mName"));
//			rs.previous();
//			rs.previous();
//			rs.previous();
//			System.out.println(rs.getString("mName"));
//			rs.first();
//			System.out.println(rs.getRow());
//		    rs.last();
//		    System.out.println(rs.getRow());
		    //---3---
//		    rs.moveToInsertRow();
//		    rs.updateString("mId", "m05");
//		    rs.updateString("mName", "mmmm");
//		    rs.updateString("mPassword", "mmmm");
//		    rs.updateInt("mSuper", 4);
//			rs.insertRow();   
//		    rs.absolute(3);
//		    rs.updateString("mPassword", "ttttt");
//		    rs.updateRow();
//		    rs.last();
//		    rs.deleteRow();
//		
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//		 
//		catch (SQLException e) {
//
//				e.printStackTrace();
//			}finally {
//				try {
//					if(rs!=null)
//						rs.close();
//					if(stat!=null)
//						stat.close();
//					if(conn!=null)
//						conn.close();
//				} catch (SQLException e) {
//
//					e.printStackTrace();
//				}
//
//			}
//		
	}

}
