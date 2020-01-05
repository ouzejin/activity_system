<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Budget" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="addBudget.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="addBudget">
<table>
<tr>
	<td>成员ID</td>
	<td>工作ID</td>
	<td>预计花费</td>
	<td>实际花费</td>
</tr>
	
<tr>
	<td><input type="text"  name="mid"    id="mid"></td>
	<td><input type="text"  name="wid"    id="wid"></td>
	<td><input type="text"  name="bcost"  id="bcost"></td>
	<td><input type="text"  name="acost"  id="acost"></td>
	<td><input type="submit" value="确认增加" onclick="return check();"></td>
</tr>

</table>
</form>
</body>
</html>