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

public class AllBudgetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//调用DAO查找所有预算信息
		BudgetDAO b = new BudgetDAO();
		Vector<Budget> V = b.findAllBudget();
		HttpSession s = req.getSession();		
		s.setAttribute("allBudget", V);
		
		//返回到budget.jsp页面并显示查找所有用户信息
		resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");

	}
}
