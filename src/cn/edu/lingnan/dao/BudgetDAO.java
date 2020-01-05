package cn.edu.lingnan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.Budget;
import cn.edu.lingnan.dto.Membership;
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
//��----����ȫ��Ԥ���¼������һ����������    
public class BudgetDAO {
public Vector<Budget> findAllBudget(){
Vector<Budget> v = new Vector<Budget>();
Connection conn = null;
Statement stat = null;
ResultSet rs = null;
try {
	conn= DataAccess.getConnection();
	stat = conn.createStatement();
	String sql = "select * from budget ";											    
	rs = stat.executeQuery(sql);				
	while(rs.next()) {
		Budget b = new Budget();
		b.setmId(rs.getString("mId"));
		b.setwId(rs.getString("wId"));
		b.setbCost(rs.getString("bCost"));
		b.setaCost(rs.getString("aCost"));
		v.add(b);
		//System.out.println(rs.getString("mName"));
	}//3 							
	
} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		DataAccess.closeConnection(rs, stat, conn);
	}
return v;
}		

//��----Ԥ�����µķ���
public boolean updateBudget(Budget b,String oldmid) {
boolean flag = false;
String mId = b.getmId();
String wId = b.getwId();
String bCost = b.getbCost();
String aCost = b.getaCost();		
Connection conn = null;
PreparedStatement prep = null;
try {
	conn=DataAccess.getConnection();
	prep = conn.prepareStatement("update budget set bCost = ?, aCost = ?, mId = ? where wId = ? and mId=?");
    prep.setString(1, bCost);
	prep.setString(2, aCost);
	prep.setString(3, mId);			
	prep.setString(4, wId);	
	prep.setString(5, oldmid);	
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


//��----����һ��Ԥ�����Ϣ
public int insertInfoToBudget(Budget b){
	int flag=0;
	String mId=b.getmId();
	String wId=b.getwId();	
	String bCost=b.getbCost();
	String aCost=b.getaCost();
	Connection conn=null;
	PreparedStatement prep=null;
	//PreparedStatement prep1=null;
	try {
		conn=DataAccess.getConnection();	
		//���ҳ�Ա����Ƿ����
		/*prep1=conn.prepareStatement("select * from membership where mid =?");
		prep1.setString(1, m.getmId());
		rs1=prep1.executeQuery();
		if(rs1.next()){//�ҵ���¼ֱ�ӷ���
			return 2;
			}*/
        prep=conn.prepareStatement("insert into Budget values(?,?,?,?)");
        prep.setString(1, mId);
        prep.setString(2, wId);
        prep.setString(3, bCost);
        prep.setString(4, aCost);
        prep.executeUpdate();
flag=1;
}catch (SQLException e) {
	e.printStackTrace();
}finally{
		DataAccess.closeConnection(prep, conn);	
		//DataAccess.closeConnection(prep1, conn);	
}		
	return flag;
}
	


//ɾ----ɾ��һ��Ԥ���¼
public boolean delete(String mid,String wid) {
	boolean flag = false;				
	Connection conn = null;
	PreparedStatement prep = null;
	try {
		conn= DataAccess.getConnection();
		prep = conn.prepareStatement
				//��budget����ͨ�����������λҪɾ���ļ�¼
				("delete from budget where mid = ? and wid = ?");
		prep.setString(1, mid);
		prep.setString(2, wid);
		prep.executeUpdate();
		flag = true;//Ϊtrueʱɾ����¼
		} catch (SQLException e) {
			try {
				conn.commit();
				conn.setAutoCommit(true);//�ύ				
				conn.rollback();//�ع�
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

/* public class BudgetDAO {
	
	//��----����һ����Աĳ��������Ԥ�㣬Ҫ���Ա�͹��������ȴ��ڵ�
	public int insertInfoToBudget(Budget b){
		int flag = 0;
		String mId = b.getmId();
		String wId = b.getwId();
		int bCost = b.getbCost();				
		Connection conn = null;
		PreparedStatement prep = null;
		PreparedStatement prep1 = null;
		ResultSet rs1 = null;
		PreparedStatement prep2 = null;
		ResultSet rs2 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");//1
			conn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/activity", "root","root");//2
			
			//�����Ա��Ų����ڷ���2
			prep1 = conn.prepareStatement("select * from membership where mId =  ?");
			prep1.setString(1, mId);
			rs1 = prep1.executeQuery();
			while(!rs1.next()) {
				flag = 2;
				return flag;
			}
			//���蹤����Ų����ڷ���3
			prep2 = conn.prepareStatement("select * from work where wId =  ?");
			prep2.setString(1, wId);
			rs2 = prep2.executeQuery();
			while(!rs2.next()) {
				flag = 3;
				return flag;
			}
			
			//����Ա��ź͹�����Ŷ����ڵ������ִ�в���Ԥ��Ĳ���
			
			prep = conn.prepareStatement("insert into budget values(?,?,?)");
			prep.setString(1, mId);
			prep.setString(2, wId);
			prep.setInt(3, bCost);
			prep.executeUpdate();
			flag = 1;							
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 
		catch (SQLException e) {
            flag = 4;//����SQL����﷨����ʱ����4
				e.printStackTrace();
			}finally {
				try {
					if(rs1!=null)
						rs1.close();
					if(rs2!=null)
						rs2.close();
					if(prep1!=null)
						prep1.close();
					if(prep2!=null)
						prep2.close();
					if(prep!=null)
						prep.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}		
		return flag;
	}

}

*/