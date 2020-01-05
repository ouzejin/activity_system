package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MembershipDAO;
import cn.edu.lingnan.dto.Membership;

public class DeleteMemServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1
	    String mid = req.getParameter("mid");		
		//2
		MembershipDAO mb = new MembershipDAO();
        boolean flag = mb.delete(mid);
	    Vector<Membership> V = mb.findAllMembership();
		HttpSession s = req.getSession();		
		s.setAttribute("allMem", V);
		//3
	    if(flag){
	    	resp.sendRedirect(req.getContextPath()+"/admin/allMem.jsp");
	    }
	    else{
	    	resp.sendRedirect(req.getContextPath()+"/error.html");
	    }
	
	}

}
