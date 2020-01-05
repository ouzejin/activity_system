package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.lingnan.dao.MembershipDAO;
import cn.edu.lingnan.dto.Membership;

public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String mid = req.getParameter("mid");
		String username = req.getParameter("username");
		String password = req.getParameter("password1");
		String msuper = req.getParameter("msuper");		
		Membership m = new Membership();
		System.out.println(mid);
		System.out.println(username);
		System.out.println(password);
		System.out.println(msuper);
		m.setmId(mid);
		m.setmName(username);
		m.setmPassword(password);
		m.setmSuper(Integer.parseInt(msuper));
		MembershipDAO mb = new MembershipDAO();
		int flag = mb.insertInfoToMember(m);
		if(flag==1)
			resp.sendRedirect(req.getContextPath()+"/index.html");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
		
	}
	
}
