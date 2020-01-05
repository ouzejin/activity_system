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

public class DeleteBudgetServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ɾ��membership��work�е�mid����widʱ��budgetҲ�ᱻ��Ӧɾ��
		//1
	    String mid = req.getParameter("mid");
	    String wid = req.getParameter("wid");
	    System.out.println(mid);
		//2
	    BudgetDAO b = new BudgetDAO();
        boolean flag = b.delete(mid, wid);//����DAO����
	    Vector<Budget> V = b.findAllBudget();//vector������Ҽ�¼
		HttpSession s = req.getSession();//����HttpSession�ӿڶ���		
		s.setAttribute("allBudget", V);
		//3
	    if(flag){//�ɹ���ת������ȫ����ҳ��
	    	resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");
	    }
	    else{//ʧ����ת������ҳ��
	    	resp.sendRedirect(req.getContextPath()+"/error.html");
	    }
	
	}
}
