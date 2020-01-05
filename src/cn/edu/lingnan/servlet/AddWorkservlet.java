package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.WorkDAO;
import cn.edu.lingnan.dto.Budget;
import cn.edu.lingnan.dto.Work;

public class AddWorkservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String wid = req.getParameter("wid");
		String wname = req.getParameter("wname");
		String etime = req.getParameter("etime");
		String atime = req.getParameter("atime");		
		Work w = new Work();
		System.out.println(wid);
		System.out.println(wname);
		System.out.println(etime);
		System.out.println(atime);
		w.setwId(wid);
		w.setwName(wname);
		w.seteTime(etime);
		w.setaTime(atime);
		WorkDAO wk = new WorkDAO();
		int flag = wk.insertInfoToWork(w);
		Vector<Work> V = wk.findAllWork();
		HttpSession s = req.getSession();
		s.setAttribute("allWork", V);	
		if(flag==1)
			resp.sendRedirect(req.getContextPath()+"/admin/allWork.jsp");
		else
			resp.sendRedirect(req.getContextPath()+"/error.html");
		
	}
}
