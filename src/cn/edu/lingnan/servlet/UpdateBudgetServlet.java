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

public class UpdateBudgetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
			String f = req.getParameter("f");			
			boolean flag = false;
			BudgetDAO bg = new BudgetDAO();
			if(f==null){//修改	修改mid时，只能改为已有的成员						
			//1
			String mid = req.getParameter("mid");
			String wid =req.getParameter("wid");
			String bcost =req.getParameter("bcost");
			String acost =req.getParameter("acost");
			String oldmid = req.getParameter("oldmid");
			Budget b = new Budget();
			System.out.println("Servlet: mid: "+mid+"wid: "+wid+"oldmid:  "+oldmid);
			b.setmId(mid);
			b.setwId(wid);
			b.setbCost(bcost);
			b.setaCost(acost);
			flag = bg.updateBudget(b,oldmid);
			System.out.println("1245");
			//2
			}else{
				if(f.equals("delall")){//进行批量删除，字符串分割成一个个记录
					String[] allmid = req.getParameterValues("allmid");
					String [] allwid = req.getParameterValues("allwid");
					String[] mid = allmid[0].split(",");
					String[] wid = allwid[0].split(",");
					for(int i=0;i<mid.length;i++){
						System.out.println("mid:  "+mid[i]+"  wid:   "+wid[i]);
						bg.delete(mid[i],wid[i]);
					}					
					flag = true;
				}else{
					//删除一条记录
					String mid = req.getParameter("mid");
					String wid = req.getParameter("wid");
					flag = bg.delete(mid, wid);
				}
				
			}
			Vector<Budget> V = bg.findAllBudget();
			HttpSession s = req.getSession();		
			s.setAttribute("allBudget", V);
			if(flag){
	    			resp.sendRedirect(req.getContextPath()+"/admin/allBudget.jsp");
	    		}
			else{
	   		 	resp.sendRedirect(req.getContextPath()+"/error.html");
	    		}
		
	}
}
