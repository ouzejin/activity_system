<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Work" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form action="updateWork">
<table>
<tr>
	<td>工作ID</td>
	<td>工作名</td>
	<td>预计时间</td>
	<td>完成时间</td>
</tr>
<%
	Vector<Work> V = (Vector<Work>)session.getAttribute("allWork");
	Iterator<Work> it = V.iterator();
	String wid = request.getParameter("wid");
	Work w = null;
	while(it.hasNext()){
		w = it.next();
		if(w.getwId().equals(wid)){					
%>		
<tr>
	<td><input type="text" name="wid" readonly="ture" value=<%= w.getwId() %>></td>
	<td><input type="text" name="wname" value=<%= w.getwName() %>></td>
	<td><input type="text" name="etime" value=<%= w.geteTime() %>></td>
	<td><input type="text" name="atime" value=<%= w.getaTime() %>></td>
	<td><input type="submit" value="确认修改"></td>
</tr>
<%		
	}}
%>
</table>
</form>
</body>
</html>