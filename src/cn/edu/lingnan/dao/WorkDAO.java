package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.Vector;

import cn.edu.lingnan.dto.Membership;
import cn.edu.lingnan.dto.Work;
import cn.edu.lingnan.util.DataAccess;

//-----���ݳ�Ա������������û��Ƿ���ڣ�������ڷ���true����������ڷ���false-----
/*public int login(String _name,String _password){
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
*/
	public class WorkDAO {
	//��----����ȫ��������¼������һ����������    
		public Vector<Work> findAllWork(){
		Vector<Work> v = new Vector<Work>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn= DataAccess.getConnection();
			stat = conn.createStatement();
			String sql = "select * from work ";											    
			rs = stat.executeQuery(sql);				
			while(rs.next()) {
				Work w = new Work();
				w.setwId(rs.getString("wId"));
				w.setwName(rs.getString("wName"));
				w.seteTime(rs.getString("eTime"));
				w.setaTime(rs.getString("aTime"));
				v.add(w);
				//System.out.println(rs.getString("wName"));
			}//3 							
			
		} catch (SQLException e) {
		
				e.printStackTrace();
			}finally {
				DataAccess.closeConnection(rs, stat, conn);
			}
		return v;
		}		
		
		//��----��������µķ���
		public boolean updateWork(Work w) {
		boolean flag = false;
		String wId = w.getwId();
		String wName = w.getwName();
		String eTime = w.geteTime();
		String aTime = w.getaTime();	
		Connection conn = null;
		PreparedStatement prep = null;
		try {
			conn=DataAccess.getConnection();
			prep = conn.prepareStatement("update work set wName = ?, eTime = ?, aTime=? where wId = ?");
		    prep.setString(1, wName);
			prep.setString(2, eTime);
			prep.setString(3, aTime);
			prep.setString(4, wId);				
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
		
		
		//��----����һ�������Ϣ
		public int insertInfoToWork(Work w){
			int flag=0;
			String wId= w.getwId();
			String wName = w.getwName();	
			String eTime = w.geteTime();	
			String aTime = w.getaTime();	
			Connection conn=null;
			PreparedStatement prep=null;
			PreparedStatement prep1=null;
			ResultSet rs1=null;
			try {
				conn=DataAccess.getConnection();	
				//���ҹ�������Ƿ����
				prep1=conn.prepareStatement("select * from work where wid =?");
				prep1.setString(1, w.getwId());
				rs1=prep1.executeQuery();
				if(rs1.next()){//�ҵ���¼ֱ�ӷ���,����ʧ�ܷ���2��
					return 2;
					}
		        prep=conn.prepareStatement("insert into work values(?,?,?,?)");
		        prep.setString(1, wId);
		        prep.setString(2, wName);
		        prep.setString(3, eTime);
		        prep.setString(4, aTime);
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
			
		
		
		//ɾ----ɾ��һ�����¼
		public boolean delete(String _wid) {
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
						("select * from work where wid = ?");
				prep2.setString(1, _wid);
				rs = prep2.executeQuery();
				Vector<String> v = new Vector<String>();
				while(rs.next()) {
				    //�ж������Ա�ǲ���ֻѡ��w01ֻ��ѡ���������������ǣ���ô��Ա��Ҫɾ��
					prep3 = conn.prepareStatement(
					"select count(*) as num from budget where mId = ?");
					prep3.setString(1,rs.getString("wId") );
					rs3 = prep3.executeQuery();
					rs3.next();
					if (Integer.parseInt(rs3.getString("num")) == 1) {
						v.add(rs.getString("wId"));//Vector������Ҫɾ���ĳ�Ա���
					}
				}
					conn.setAutoCommit(false);						
					//��Ȼɾ�����˹�������ô����ɾ���ù�����Ԥ��
					prep1 = conn.prepareStatement
							("delete from budget where wid = ?");
					prep1.setString(1, _wid);
					prep1.executeUpdate();
					//----------��ɾ��������¼---------------
					prep = conn.prepareStatement
					("delete from work where wid = ?");
					prep.setString(1, _wid);
					prep.executeUpdate();
					//----------���ɾ����Ա��¼---------------
					for(String a:v) {
						prep4 = conn.prepareStatement
							("delete from membership where mid = ?");
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

/* public class WorkDAO {
	
	//��----�������µķ���
	public boolean updateWork(Work w) {
		boolean flag = false;
		String wId = w.getwId();
		String wName = w.getwName();
		Connection conn = null;
		PreparedStatement prep = null;
		
		try {
			conn=DataAccess.getConnection();
			prep = conn.prepareStatement("update Work set wName = ? where wId = ?");
		    prep.setString(1, wName);
			prep.setString(2, wId);
			prep.executeUpdate();
			flag = true;
			
		} catch (SQLException e) {

				e.printStackTrace();
			}finally {
				DataAccess.closeConnection(prep, conn);

			}
	
		return flag;
	}
	
}
*/
