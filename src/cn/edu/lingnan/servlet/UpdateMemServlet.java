package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dao.MembershipDAO;
import cn.edu.lingnan.dto.Membership;

public class UpdateMemServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("GBK");
	String f = req.getParameter("f");
	boolean flag = false;
	MembershipDAO mb = new MembershipDAO();
	if(f==null){//修改
		//解决Tomcat7GBK乱码问题，String newStr = new String(request.getParameter("pageParamName").getBytes("ISO-8859-1"),"GBK");
		//同时要将Navicat中配置表的字符选项为gbk
		//
		//String mname =req.getParameter("mname");
		String mid =req.getParameter("mid");
		String mname = new String(req.getParameter("mname").getBytes("ISO-8859-1"),"GBK");
		System.out.println(mname);
		String mpassword =req.getParameter("mpassword");
		int  msuper =Integer.parseInt(req.getParameter("msuper"));
		Membership m = new Membership();
		m.setmId(mid);
		m.setmName(mname);
		m.setmPassword(mpassword);
		m.setmSuper(msuper);
	    mb = new MembershipDAO();
		flag = mb.updateMembership(m);
	}else{//删除	
	    if(f.equals("delall")){//进行批量删除 字符串分割成一个个记录
	    	String[] allmid = req.getParameterValues("allmid");
	    	String[] temp = allmid[0].split(",");
	    	for(String a : temp){
	    		mb.delete(a);
	    	}
	    	flag = true;
	    }else{//否则删除一条记录
			String mid = req.getParameter("mid");		
		    flag = mb.delete(mid);	
	    }
	
	}	
	Vector<Membership> V = mb.findAllMembership();
	HttpSession s = req.getSession();		
	s.setAttribute("allMem", V);
	if(flag){
    	resp.sendRedirect(req.getContextPath()+"/admin/allMem.jsp");
    }
    else{
    	resp.sendRedirect(req.getContextPath()+"/error.html");
    }
	
  }

}
