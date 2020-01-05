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
		
		//����DAO��������Ԥ����Ϣ
		BudgetDAO b = new BudgetDAO();
		Vector<Budget> V = b.findAllBudget();
		HttpSession s = req.getSession();		
		s.setAttribute("allBudget", V);
		
		//���ص�budget.jspҳ�沢��ʾ���������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");

	}
}
