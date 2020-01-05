package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.WorkDAO;
import cn.edu.lingnan.dto.Work;

public class allWServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//调用DAO查找所有工作信息
		WorkDAO w = new WorkDAO();
		Vector<Work> V = w.findAllWork();
		HttpSession s = req.getSession();		
		s.setAttribute("allWork", V);
		//返回到work.jsp页面并显示查找所有用户信息
		resp.sendRedirect(req.getContextPath()+"/notAdmin/allWork.jsp");
	}

}
