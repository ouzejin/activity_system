<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Work" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="addWork.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<form name="form" action="addWork">
<table>
<tr>
	<td>����ID</td>
	<td>������</td>
	<td>Ԥ��ʱ��</td>
	<td>���ʱ��</td>
</tr>
	
<tr>
	<td><input type="text"  name="wid"    id="wid"></td>
	<td><input type="text"  name="wname"  id="wname"></td>
	<td><input type="text"  name="etime"  id="etime"></td>
	<td><input type="text"  name="atime"  id="atime"></td>
	<td><input type="submit" value="ȷ������" onclick="return check();"></td>
</tr>

</table>
</form>
</body>
</html>