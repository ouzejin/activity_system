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

public class DeleteWorkServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1
	    String wid = req.getParameter("wid");		
		//2
	    WorkDAO w = new WorkDAO();
        boolean flag = w.delete(wid);
	    Vector<Work> V = w.findAllWork();
		HttpSession s = req.getSession();		
		s.setAttribute("allWork", V);
		//3
	    if(flag){
	    	resp.sendRedirect(req.getContextPath()+"/admin/allWork.jsp");
	    }
	    else{
	    	resp.sendRedirect(req.getContextPath()+"/error.html");
	    }
	
	}
}
