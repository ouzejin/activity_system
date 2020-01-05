package cn.edu.lingnan.test;

import java.util.Scanner;

import com.mysql.jdbc.Connection;

import cn.edu.lingnan.dao.MembershipDAO;
import cn.edu.lingnan.dao.WorkDAO;
import cn.edu.lingnan.dto.Membership;
import cn.edu.lingnan.dto.Work;
import cn.edu.lingnan.util.DataAccess;

public class HomePage {

	public static void main(String[] args) {
		Connection conn = null;
		String mName;
		int choose;
		int  select1, select2, select3, select4, select5;
		conn = DataAccess.getConnection();
		WorkDAO s2=new WorkDAO();
		Work c2=new Work();
		Scanner reader = new Scanner(System.in);
		System.out.println("-----****---------------------Welcome---------------------------****-------");
		System.out.println("----------------------------活动管理系统------------------------------------");
		System.out.println("------------------------------欧泽金---------------------------------------");
		System.out.println("--------------------------***************------------------2019.3.25-------");
		do
		{
			System.out.println("请选择服务的种类：");
			System.out.println("   1.查询");
			System.out.println("   2.增加");
			System.out.println("   3.更新");
			System.out.println("   4.删除");
			System.out.println("   0.退出");
			System.out.println("请选择：");
			choose = reader.nextInt();
			while(choose<0||choose>4)//判断输入的数据是否为数字
			{
				System.out.println("\n\t输入有误，请重新输入!");
				System.out.println();
				break;
			}
			switch(choose)
			{
         case 1:
            System.out.println("请选择查询：");
 			System.out.println("    1.团员信息");
 			System.out.println("    2.活动信息");
 			System.out.println("    3.报名记录");
 			System.out.println("    0.返回上一层");
 			System.out.println("请选择：");
 			select1 = reader.nextInt(); 
 			   if(select1<0||select1>3)//判断输入的数据是否为数字
 				  { System.out.println("\n\t输入有误，请重新输入!");
 					System.out.println();
 		            break;}
 			   switch(select1)
 			   {
 			   case 1:
 				    System.out.println("请输入姓名: ");
 				    MembershipDAO s1=new MembershipDAO();
 				    Membership c1=new Membership();
 				    Scanner reader1 = new Scanner(System.in);
 				    String _name;
 				   _name=reader1.next();
				  System.out.println(s1.findMemberByName(_name));
				  break;
 			   case 2:
 				  System.out.println("请选择查找的方法：");
 				  System.out.println("    1.活动ID");
 	 			  System.out.println("    2.活动名称");
 	 			  System.out.println("    0.返回上一层");
 	 			  System.out.println("请选择：");
 	 			  select2=reader.nextInt();
 	 			 if(select2<0||select2>3)//判断输入的数据是否为数字
				  { System.out.println("\n\t输入有误，请重新输入!");
					System.out.println();
		            break;}
 	 			 if (select2==1){
 	 				  System.out.println("请输入活动ID：");
 	 				  Scanner reader2 = new Scanner(System.in);
 	 				   String _id;
 	 				   _id=reader2.next();
 	 				  System.out.println(s2.findActivityByid(_id));}
 	 			 if(select2==2){ 
 				   System.out.println("请输入活动Name：");
 				   Scanner reader2 = new Scanner(System.in);
 				   String _name2;
 				   _name2=reader2.next();
 				  System.out.println(s2.findActivityByName(_name2));}
 	 			 if(select2==0){break;}
 				break;
 			    case 3:
 				 break;     
 			   }break;
           case 2:
            	System.out.println("请选择增加：");
       			System.out.println("      1.增加团员信息");
       			System.out.println("      2.增加活动信息");
       			System.out.println("      3.增加活动记录");
       			System.out.println("      0.返回主菜单");
       			select3=reader.nextInt();
       			if(select3<1||select3>3){System.out.println("\n\t输入有误，请重新输入!");}  
       			if(select3==2){
       				System.out.println("输入要增加的活动Id:");
       				Scanner reader3=new Scanner(System.in);
       				String aId;
       				aId = reader3.nextLine();
       				c2.setaId(aId);
       				
       				System.out.println("输入要增加的活动名称:");
       				Scanner reader4=new Scanner(System.in);
       				String aName;
       				aName=reader4.nextLine();
       				c2.setaName(aName);
       				
       				System.out.println("输入要增加的活动电话:");
       				Scanner reader5=new Scanner(System.in);
       				String aPhone;
       				aPhone=reader5.nextLine();
       				c2.setaPhone(aPhone);
       				
       				System.out.println(s2.insertInfoToActivity(c2));
       				
       			}
       			break;
 			   
             case 3:
           	    System.out.println("请选择更新：");
      			System.out.println("     1.团员信息");
      			System.out.println("     2.活动信息");
      			System.out.println("     3.报名记录");
      			System.out.println("     0.主菜单");
      			select4=reader.nextInt();
      			if(select4<0||select4>3){System.out.println("输入有误");}
      			if(select4==2){
      				System.out.println("输入已存在的活动，更新名称");
      				System.out.println("输入活动id：");
      				Scanner reader6=new Scanner(System.in);
      				String aId;
      				aId=reader6.nextLine();
      				c2.setaId(aId);
      				
      				System.out.println("输入要更新的名称：");
      				Scanner reader7=new Scanner(System.in);
      				String aName;
      				aName=reader7.nextLine();
      				c2.setaName(aName);
      				
      				System.out.println("输入更新活动的联系方式：");
      				Scanner reader8=new Scanner(System.in);
      				String aPhone;
      				aPhone=reader8.nextLine();
      				c2.setaPhone(aPhone);
      				
      				System.out.println(s2.updataActivity(c2));
      			}
      			break;	
       			
             case 4:
              	    System.out.println("请选择删除：");
         			System.out.println("    1.团员信息");
         			System.out.println("    2.活动信息");
         			System.out.println("    3.报名记录");
         			System.out.println("    0.返回主菜单");
         			select5=reader.nextInt();
         			if(select5==2){
         				System.out.println("请输入要删除的id：");
         				Scanner reader8=new Scanner(System.in);
         				String aId;
         				aId=reader8.nextLine();
         				c2.setaId(aId);
         				System.out.println(s2.deleteActivity(aId));
         			}
         			break;	
         		
	          }
		}while(choose!=0);
	}

}
