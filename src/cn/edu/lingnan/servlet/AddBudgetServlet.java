package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.BudgetDAO;
import cn.edu.lingnan.dto.Budget;

public class AddBudgetServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("xxxx");
		String mid = req.getParameter("mid");
		String wid = req.getParameter("wid");
		String bcost = req.getParameter("bcost");
		String acost = req.getParameter("acost");		
		Budget b = new Budget();
		BudgetDAO bg = new BudgetDAO();
		b.setmId(mid);
		b.setwId(wid);
		b.setbCost(bcost);
		b.setaCost(acost);
		System.out.println(mid);
		System.out.println(wid);
		System.out.println(bcost);
		System.out.println(acost);
		int flag = bg.insertInfoToBudget(b);
		Vector<Budget> V = bg.findAllBudget();
		HttpSession s = req.getSession();
		s.setAttribute("allBudget", V);	
		if(flag==1)
			resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
		
	}
}
