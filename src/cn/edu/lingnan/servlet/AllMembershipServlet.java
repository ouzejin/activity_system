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

public class AllMembershipServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//����DAO���������û���Ϣ
		MembershipDAO mb = new MembershipDAO();
		Vector<Membership> V = mb.findAllMembership();
		HttpSession s = req.getSession();		
		s.setAttribute("allMem", V);
		
		//���ص�membership.jspҳ�沢��ʾ���������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allMem.jsp");

	}

}
