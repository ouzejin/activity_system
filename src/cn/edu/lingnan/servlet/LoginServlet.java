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

		//1 获取客户端提交的参数
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("LoginServlet:"+username+"       "+password);
		
		//2 处理一下参数，调用业务逻辑
		MembershipDAO ms = new MembershipDAO();
		int mSuper = ms.login(username,password);
		HttpSession s = req.getSession();
		s.setAttribute("mSuper", mSuper);
		
				
		
		//3 根据返回的结果处理
		if(mSuper !=0){
			resp.sendRedirect(req.getContextPath()+"/succeed.html");
			
		}else{
			resp.sendRedirect(req.getContextPath()+"/error.html");			
		}
		
	}
	

}
