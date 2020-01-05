package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MembershipDAO;

public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//1 ��ȡ�ͻ����ύ�Ĳ���
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("LoginServlet:"+username+"       "+password);
		
		//2 ����һ�²���������ҵ���߼�
		MembershipDAO ms = new MembershipDAO();
		int mSuper = ms.login(username,password);
		HttpSession s = req.getSession();
		s.setAttribute("mSuper", mSuper);
		
				
		
		//3 ���ݷ��صĽ������
		if(mSuper !=0){
			resp.sendRedirect(req.getContextPath()+"/succeed.html");
			
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");			
		}
		
	}
	

}
