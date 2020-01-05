	package cn.edu.lingnan.dao;

	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    import java.util.Vector;

    import  cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;

    public class MembershipDAO {

//-----根据成员名和密码查找用户是否存在，如果存在返回true，如果不存在返回false-----
		    public int login(String _name,String _password){
			int flag = 0;
			Connection conn = null;
			PreparedStatement prep = null;
			ResultSet rs = null;
			try {	
				conn = DataAccess.getConnection();
				prep = conn.prepareStatement
						("select * from membership where mName = ? and  mPassword = ?");
				prep.setString(1, _name);
				prep.setString(2, _password);
				rs = prep.executeQuery();
				
				if(rs.next()){
					flag = rs.getInt("mSuper");
				}
														
			} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					DataAccess.closeConnection(rs, prep, conn);

				}
			return flag;

		}

		//查----查找全部成员记录，返回一个对象数组    
		public Vector<Membership> findAllMembership(){
			Vector<Membership> v = new Vector<Membership>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn= DataAccess.getConnection();
				stat = conn.createStatement();
				String sql = "select * from membership ";											    
				rs = stat.executeQuery(sql);				
				while(rs.next()) {
					Membership m = new Membership();
					m.setmId(rs.getString("mId"));
					m.setmName(rs.getString("mName"));
					m.setmPassword(rs.getString("mPassword"));
					m.setmSuper(rs.getInt("mSuper"));
					v.add(m);
					//System.out.println(rs.getString("mName"));
				}//3 							
				
			} catch (SQLException e) {

					e.printStackTrace();
				}finally {
					DataAccess.closeConnection(rs, stat, conn);
				}
	    	return v;
		}		

		//改----成员表更新的方法
		public boolean updateMembership(Membership m) {
			boolean flag = false;
			String mId = m.getmId();
			String mName = m.getmName();
			String mPassword = m.getmPassword();
			int mSuper = m.getmSuper();		
			Connection conn = null;
			PreparedStatement prep = null;
			try {
				conn=DataAccess.getConnection();
				prep = conn.prepareStatement("update membership set mName = ?, mPassword = ?, mSuper = ? where mId = ?");
			    prep.setString(1, mName);
			    System.out.println("mName:  "+mName);
				prep.setString(2, mPassword);
				prep.setInt(3, mSuper);
				prep.setString(4, mId);				
				prep.executeUpdate();
				flag = true;
				
			} catch (SQLException e) {

					e.printStackTrace();
				}
			
			finally {
					DataAccess.closeConnection(prep, conn);

				}
			
			return flag;
		}

		
		//增----插入一个成员的信息
		  public int insertInfoToMember(Membership m){
				int flag=0;
				String mId=m.getmId();
				String mName=m.getmName();	
				String mPassword=m.getmPassword();
				int mSuper=m.getmSuper();
				Connection conn=null;
				PreparedStatement prep=null;
				PreparedStatement prep1=null;
				ResultSet rs1=null;
				try {
					conn=DataAccess.getConnection();	
					//查找成员编号是否存在
					prep1=conn.prepareStatement("select * from membership where mid =?");
					prep1.setString(1, m.getmId());
					rs1=prep1.executeQuery();
					if(rs1.next()){//找到记录直接返回
						return 2;
						}
			        prep=conn.prepareStatement("insert into Membership values(?,?,?,?)");
			        prep.setString(1, mId);
			        prep.setString(2, mName);
			        prep.setString(3, mPassword);
			        prep.setInt(4, mSuper);
			        prep.executeUpdate();
			flag=1;
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
					DataAccess.closeConnection(prep, conn);	
					DataAccess.closeConnection(prep1, conn);	
			}		
				return flag;
		}
				
		
		
	    //删----删除一条成员记录
			public boolean delete(String _mid) {
				boolean flag = false;				
				Connection conn = null;
				PreparedStatement prep1 = null;
				PreparedStatement prep2 = null;
				PreparedStatement prep3 = null;
				PreparedStatement prep4 = null;
				PreparedStatement prep = null;
				ResultSet rs3 = null;
				ResultSet rs = null;
				try {
					conn= DataAccess.getConnection();
					prep2 = conn.prepareStatement
							("select * from budget where mid = ?");
					prep2.setString(1, _mid);
					rs = prep2.executeQuery();
					Vector<String> v = new Vector<String>();
					while(rs.next()) {
						//判断这个工作是不是只有m01只有这一位成员选了，如果是，那么工作需要删除
						prep3 = conn.prepareStatement(
						"select count(*) as num from budget where wId = ?");
						prep3.setString(1,rs.getString("wId") );
						rs3 = prep3.executeQuery();
						rs3.next();
						if (Integer.parseInt(rs3.getString("num")) == 1) {
							v.add(rs.getString("wId"));//Vector里面是要删除的工作编号
						}
					}
						conn.setAutoCommit(false);						
						//既然删除不了成员，那么我先删除该成员的预算
						prep1 = conn.prepareStatement
								("delete from budget where mid = ?");
						prep1.setString(1, _mid);
						prep1.executeUpdate();
						//----------再删除成员记录---------------
						prep = conn.prepareStatement
						("delete from membership where mid = ?");
						prep.setString(1, _mid);
						prep.executeUpdate();
						//----------最后删除工作记录---------------
						for(String a:v) {
							prep4 = conn.prepareStatement
								("delete from work where wid = ?");
							prep4.setString(1,a);
							prep4.executeUpdate();
						}																																														
					conn.commit();
					conn.setAutoCommit(true);
					flag=true;					
					} catch (SQLException e) {
						try {
							conn.rollback();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						e.printStackTrace();
					}finally {
						DataAccess.closeConnection(prep, conn);

					}				
				return flag;
				
			}
}
		