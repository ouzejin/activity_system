<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Budget" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form action="updateBudget">
<table>
<tr>
	<td>��ԱID</td>
	<td>����ID</td>
	<td>Ԥ�ƻ���</td>
	<td>ʵ�ʻ���</td>
</tr>
<%
	Vector<Budget> V = (Vector<Budget>)session.getAttribute("allBudget");
	Iterator<Budget> it = V.iterator();
	String wid = request.getParameter("wid");
	String mid = request.getParameter("mid");
	String oldmid = mid;
	Budget b = null;
	while(it.hasNext()){
		b = it.next();
		if(b.getwId().equals(wid)&&b.getmId().equals(mid)){	
%>		
<tr>
	<td><input type="text" name="mid"  value=<%= b.getmId() %>></td>
	<td><input type="text" name="wid" readonly="true" value=<%= b.getwId() %>></td>
	<td><input type="text" name="bcost" value=<%= b.getbCost() %>></td>
	<td><input type="text" name="acost" value=<%= b.getaCost() %>></td>
	<td><input type="submit" value="ȷ���޸�"></td>
	<td><input type="hidden" name="oldmid" value=<%=oldmid %>></td>
</tr>
<%		
	}}
%>
</table>
</form>
</body>
</html>