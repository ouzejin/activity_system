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
		
		//����DAO�������й�����Ϣ
		WorkDAO w = new WorkDAO();
		Vector<Work> V = w.findAllWork();
		HttpSession s = req.getSession();		
		s.setAttribute("allWork", V);
		//���ص�work.jspҳ�沢��ʾ���������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/notAdmin/allWork.jsp");
	}

}
