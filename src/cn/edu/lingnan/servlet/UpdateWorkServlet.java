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

public class UpdateWorkServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.setCharacterEncoding("GBK");
			//1
			String f = req.getParameter("f");
			boolean flag = false;
			WorkDAO wk = new WorkDAO();
			if(f==null){//修改String newStr = new String(request.getParameter("pageParamName").getBytes("ISO-8859-1"),"GBK");
			String wname = new String(req.getParameter("wname").getBytes("ISO-8859-1"),"GBK");
			String etime = new String(req.getParameter("etime").getBytes("ISO-8859-1"),"GBK");
			String atime = new String(req.getParameter("atime").getBytes("ISO-8859-1"),"GBK");
			String wid =req.getParameter("wid");
			System.out.println("wid");
			System.out.println("wname");
			System.out.println("etime");
			System.out.println("atime");
			Work w = new Work();
			w.setwId(wid);
			w.setwName(wname);
			w.seteTime(etime);
			w.setaTime(atime);
			wk = new WorkDAO();
			flag = wk.updateWork(w);
			//2
			}else{//删除
			if(f.equals("delall")){//进行批量删除 字符串分割成一个个记录
				String[] allwid = req.getParameterValues("allwid");
				String[] temp = allwid[0].split(",");
				for(String a : temp){
					wk.delete(a);
				}
				flag = true;
			}else{//否则删除一条记录
				String wid = req.getParameter("wid");
				flag = wk.delete(wid);
			}
				
		}
			Vector<Work> V = wk.findAllWork();
			HttpSession s = req.getSession();		
			s.setAttribute("allWork", V);
			System.out.println("xx="+V.elementAt(0).getwId());
			if(flag){
	    			resp.sendRedirect(req.getContextPath()+"/admin/allWork.jsp");
	    		}
			else{
	   		 	resp.sendRedirect(req.getContextPath()+"/error.html");
	    		}
		
	}


}
