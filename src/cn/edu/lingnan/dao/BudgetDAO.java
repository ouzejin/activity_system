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

//-----根据成员名和密码查找用户是否存在，如果存在返回true，如果不存在返回false-----
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
//查----查找全部预算记录，返回一个对象数组    
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

//改----预算表更新的方法
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


//增----插入一个预算的信息
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
		//查找成员编号是否存在
		/*prep1=conn.prepareStatement("select * from membership where mid =?");
		prep1.setString(1, m.getmId());
		rs1=prep1.executeQuery();
		if(rs1.next()){//找到记录直接返回
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
	


//删----删除一条预算记录
public boolean delete(String mid,String wid) {
	boolean flag = false;				
	Connection conn = null;
	PreparedStatement prep = null;
	try {
		conn= DataAccess.getConnection();
		prep = conn.prepareStatement
				//从budget表中通过两个外键定位要删除的记录
				("delete from budget where mid = ? and wid = ?");
		prep.setString(1, mid);
		prep.setString(2, wid);
		prep.executeUpdate();
		flag = true;//为true时删除记录
		} catch (SQLException e) {
			try {
				conn.commit();
				conn.setAutoCommit(true);//提交				
				conn.rollback();//回滚
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
	
	//增----插入一个成员某个工作的预算，要求成员和工作是事先存在的
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
			
			//假设成员编号不存在返回2
			prep1 = conn.prepareStatement("select * from membership where mId =  ?");
			prep1.setString(1, mId);
			rs1 = prep1.executeQuery();
			while(!rs1.next()) {
				flag = 2;
				return flag;
			}
			//假设工作编号不存在返回3
			prep2 = conn.prepareStatement("select * from work where wId =  ?");
			prep2.setString(1, wId);
			rs2 = prep2.executeQuery();
			while(!rs2.next()) {
				flag = 3;
				return flag;
			}
			
			//当成员编号和工作编号都存在的情况下执行插入预算的操作
			
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
            flag = 4;//出现SQL语句语法错误时返回4
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