<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Membership" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="updateMem.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form action="updateMem">
<table>
<tr>
	<td>ID</td>
	<td>姓名</td>
	<td>密码</td>
	<td>权限</td>
</tr>
<%
	Vector<Membership> V = (Vector<Membership>)session.getAttribute("allMem");
	Iterator<Membership> it = V.iterator();
	String mid = request.getParameter("mid");
	Membership m = null;
	while(it.hasNext()){
		m = it.next();
		if(m.getmId().equals(mid)){					
%>		
<tr>
	<td><input type="text" name="mid" readonly="ture" value=<%= m.getmId() %> ></td>
	<td><input type="text" name="mname" value=<%= m.getmName() %> ></td>
	<td><input type="text" name="mpassword" value=<%= m.getmPassword() %> ></td>
	<td><input type="text" name="msuper" value=<%= m.getmSuper() %> ></td>
	<td><input type="submit" value="确认修改" onclick="return check();">	</td>
</tr>
<%		
	}}
%>
</table>
</form>
</body>
</html>