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
		System.out.println("----------------------------�����ϵͳ------------------------------------");
		System.out.println("------------------------------ŷ���---------------------------------------");
		System.out.println("--------------------------***************------------------2019.3.25-------");
		do
		{
			System.out.println("��ѡ���������ࣺ");
			System.out.println("   1.��ѯ");
			System.out.println("   2.����");
			System.out.println("   3.����");
			System.out.println("   4.ɾ��");
			System.out.println("   0.�˳�");
			System.out.println("��ѡ��");
			choose = reader.nextInt();
			while(choose<0||choose>4)//�ж�����������Ƿ�Ϊ����
			{
				System.out.println("\n\t������������������!");
				System.out.println();
				break;
			}
			switch(choose)
			{
         case 1:
            System.out.println("��ѡ���ѯ��");
 			System.out.println("    1.��Ա��Ϣ");
 			System.out.println("    2.���Ϣ");
 			System.out.println("    3.������¼");
 			System.out.println("    0.������һ��");
 			System.out.println("��ѡ��");
 			select1 = reader.nextInt(); 
 			   if(select1<0||select1>3)//�ж�����������Ƿ�Ϊ����
 				  { System.out.println("\n\t������������������!");
 					System.out.println();
 		            break;}
 			   switch(select1)
 			   {
 			   case 1:
 				    System.out.println("����������: ");
 				    MembershipDAO s1=new MembershipDAO();
 				    Membership c1=new Membership();
 				    Scanner reader1 = new Scanner(System.in);
 				    String _name;
 				   _name=reader1.next();
				  System.out.println(s1.findMemberByName(_name));
				  break;
 			   case 2:
 				  System.out.println("��ѡ����ҵķ�����");
 				  System.out.println("    1.�ID");
 	 			  System.out.println("    2.�����");
 	 			  System.out.println("    0.������һ��");
 	 			  System.out.println("��ѡ��");
 	 			  select2=reader.nextInt();
 	 			 if(select2<0||select2>3)//�ж�����������Ƿ�Ϊ����
				  { System.out.println("\n\t������������������!");
					System.out.println();
		            break;}
 	 			 if (select2==1){
 	 				  System.out.println("������ID��");
 	 				  Scanner reader2 = new Scanner(System.in);
 	 				   String _id;
 	 				   _id=reader2.next();
 	 				  System.out.println(s2.findActivityByid(_id));}
 	 			 if(select2==2){ 
 				   System.out.println("������Name��");
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
            	System.out.println("��ѡ�����ӣ�");
       			System.out.println("      1.������Ա��Ϣ");
       			System.out.println("      2.���ӻ��Ϣ");
       			System.out.println("      3.���ӻ��¼");
       			System.out.println("      0.�������˵�");
       			select3=reader.nextInt();
       			if(select3<1||select3>3){System.out.println("\n\t������������������!");}  
       			if(select3==2){
       				System.out.println("����Ҫ���ӵĻId:");
       				Scanner reader3=new Scanner(System.in);
       				String aId;
       				aId = reader3.nextLine();
       				c2.setaId(aId);
       				
       				System.out.println("����Ҫ���ӵĻ����:");
       				Scanner reader4=new Scanner(System.in);
       				String aName;
       				aName=reader4.nextLine();
       				c2.setaName(aName);
       				
       				System.out.println("����Ҫ���ӵĻ�绰:");
       				Scanner reader5=new Scanner(System.in);
       				String aPhone;
       				aPhone=reader5.nextLine();
       				c2.setaPhone(aPhone);
       				
       				System.out.println(s2.insertInfoToActivity(c2));
       				
       			}
       			break;
 			   
             case 3:
           	    System.out.println("��ѡ����£�");
      			System.out.println("     1.��Ա��Ϣ");
      			System.out.println("     2.���Ϣ");
      			System.out.println("     3.������¼");
      			System.out.println("     0.���˵�");
      			select4=reader.nextInt();
      			if(select4<0||select4>3){System.out.println("��������");}
      			if(select4==2){
      				System.out.println("�����Ѵ��ڵĻ����������");
      				System.out.println("����id��");
      				Scanner reader6=new Scanner(System.in);
      				String aId;
      				aId=reader6.nextLine();
      				c2.setaId(aId);
      				
      				System.out.println("����Ҫ���µ����ƣ�");
      				Scanner reader7=new Scanner(System.in);
      				String aName;
      				aName=reader7.nextLine();
      				c2.setaName(aName);
      				
      				System.out.println("������»����ϵ��ʽ��");
      				Scanner reader8=new Scanner(System.in);
      				String aPhone;
      				aPhone=reader8.nextLine();
      				c2.setaPhone(aPhone);
      				
      				System.out.println(s2.updataActivity(c2));
      			}
      			break;	
       			
             case 4:
              	    System.out.println("��ѡ��ɾ����");
         			System.out.println("    1.��Ա��Ϣ");
         			System.out.println("    2.���Ϣ");
         			System.out.println("    3.������¼");
         			System.out.println("    0.�������˵�");
         			select5=reader.nextInt();
         			if(select5==2){
         				System.out.println("������Ҫɾ����id��");
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
