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
		//删除membership和work中的mid或者wid时，budget也会被对应删除
		//1
	    String mid = req.getParameter("mid");
	    String wid = req.getParameter("wid");
	    System.out.println(mid);
		//2
	    BudgetDAO b = new BudgetDAO();
        boolean flag = b.delete(mid, wid);//调用DAO方法
	    Vector<Budget> V = b.findAllBudget();//vector数组查找记录
		HttpSession s = req.getSession();//创建HttpSession接口对象		
		s.setAttribute("allBudget", V);
		//3
	    if(flag){//成功跳转到查找全部的页面
	    	resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");
	    }
	    else{//失败跳转到错误页面
	    	resp.sendRedirect(req.getContextPath()+"/error.html");
	    }
	
	}
}
