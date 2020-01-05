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

//-----���ݳ�Ա������������û��Ƿ���ڣ�������ڷ���true����������ڷ���false-----
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

		//��----����ȫ����Ա��¼������һ����������    
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

		//��----��Ա����µķ���
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

		
		//��----����һ����Ա����Ϣ
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
					//���ҳ�Ա����Ƿ����
					prep1=conn.prepareStatement("select * from membership where mid =?");
					prep1.setString(1, m.getmId());
					rs1=prep1.executeQuery();
					if(rs1.next()){//�ҵ���¼ֱ�ӷ���
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
				
		
		
	    //ɾ----ɾ��һ����Ա��¼
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
						//�ж���������ǲ���ֻ��m01ֻ����һλ��Աѡ�ˣ�����ǣ���ô������Ҫɾ��
						prep3 = conn.prepareStatement(
						"select count(*) as num from budget where wId = ?");
						prep3.setString(1,rs.getString("wId") );
						rs3 = prep3.executeQuery();
						rs3.next();
						if (Integer.parseInt(rs3.getString("num")) == 1) {
							v.add(rs.getString("wId"));//Vector������Ҫɾ���Ĺ������
						}
					}
						conn.setAutoCommit(false);						
						//��Ȼɾ�����˳�Ա����ô����ɾ���ó�Ա��Ԥ��
						prep1 = conn.prepareStatement
								("delete from budget where mid = ?");
						prep1.setString(1, _mid);
						prep1.executeUpdate();
						//----------��ɾ����Ա��¼---------------
						prep = conn.prepareStatement
						("delete from membership where mid = ?");
						prep.setString(1, _mid);
						prep.executeUpdate();
						//----------���ɾ��������¼---------------
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
		