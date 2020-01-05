<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.Membership" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="allMem.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<style> table{text-align:center} </style> 
<style type="text/css">
		header{
			width: 100%;
			height: 120px;
			background: linear-gradient(green,#91e374);
		}

		h2#text1{
			margin: 0px;
			padding: 0px;
			top: 20px;
			position: absolute;
			font-size: 60px;
			margin-left: 65px;
		}

		h2#text2{
			margin: 0px;
			padding: 0px;
			position: absolute;
			font-size: 45px;
			color: white;
			margin-left: 180px;
			z-index: 1;
			top: 50px;
			text-shadow:7px 7px 7px black; 
		}
		
		h3#text3{
			margin: 0px;
			padding: 0px;
			top: 60px;
			position: absolute;
			font-size: 32px;
			margin-left:1350px;
		}
		
		h3:hover{
		    color: white;
		    z-index: 1;
			text-shadow:5px 5px 5px black; 
		}

		aside{
			height: 500px;
			width: 30%;
            background-color: #91e374;
			float: left;
		}

		.aside-top{
			height: 250px;
			width: 100%;
			background-color: black;
		}

		.aside-bottom{
			height: 250px;
		}

		.little{
			border: solid 3px black;
			height: 35px;
			width: 120px;
            margin-top: 35px;
           border-radius: 5px;
           margin-left: 150px;
           line-height: 30px;
		}

        .little:hover{
        	transform: scale(1.2);
        	background-color: #1bcc00;
        }
	
		a{
			display: block;
			text-decoration: none;
			font-size: 18px;
			font-family:;
			font-weight: bold;
			text-align: center;
			color: black;
		}

		article{
			height: 500px;
			width: 70%;
			background-color: #efffff;
			float: left;
			font-size: 20px;
		}
        
        .text{
        	text-indent: 2em;
        }
		
		.consection{
			display: block;
			border: 0px black solid;
			width: 500px;
			left: -10px;
			top: 30px;
			margin: 0px auto;
			padding: 40px;
			font-size: 20px;
			position: relative;
		}
		
		td:hover{
			background-color: #1bcc00;
		}

		fieldset{
        	border: 2px solid black;
        }
		
		
		
		footer{
			width: 100%;
			height: 100px;
			background: linear-gradient(#91e374,green);
			text-align: center;
			font-size: 30px;
			color: black;
			float: left;
			line-height: 100px;
		}

	  .div.td table td{
	  		font-size: 20px;	  
	  }
	  	</style>

<title>Insert title here</title>
</head>
<body>
<header>
<h2 id="text1">Activity System</h2>
<h2 id="text2">Activity System</h2>
<a href="http://localhost:8080/JavaWeb201903/index.html"><h3 id="text3">Logout</h3></a>
</header>
<aside>
	<div class="aside-top">
	<img src="../images/ze.jpg" width="100%" height="250px">
	</img>
	</div>
	
	<div class="aside-bottom">
	<a href="findAllMem"><div class="little">Membership</div></a>
	<a href="allWork"><div class="little">Work</div></a>
	<a href="allBudget"><div class="little">Budget</div></a>
	</div>
</aside>
<article>
<div class="consection">

<legend>
全部成员的信息<br><br>
</legend>
<div>
<table border="1px" bordercolor="#000000" cellspacing="0px" onmousemove="##efffff"
width="600px">
<tr>
	<td><input id="btn1" type="button" value="全选" onclick="allcheck();"/></td>
	<td>ID</td>
	<td>姓名</td>
	<td>密码</td>
	<td>权限</td>
	<td><input id="btn2" type="button" value="批量删除" onclick="delAllMem();"/></td>
	<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
</tr>

<%

	Vector<Membership> V = (Vector<Membership>)session.getAttribute("allMem");
	Iterator<Membership> it = V.iterator();
	Membership m = null;
	while(it.hasNext()){
		m = it.next();
		/* 留下一个管理员账号，不会全选删除时全没了。 */
		if(!m.getmId().equals("m01")){
		
%>		
<tr>
	<td><input type="checkbox" name="check" value=<%= m.getmId() %>></td>
	<td><%= m.getmId() %></td>
	<td><%= m.getmName() %></td>
	<td><%= m.getmPassword() %></td>
	<td><%= m.getmSuper() %></td>
	<td>
		<a href="updateMem?f=del&mid=<%=m.getmId()  %>"
			onclick="return confirm('您确定要删除该条记录嘛？');">删  除</a></td>
	<td>	<a href="updateMem.jsp?mid=<%=m.getmId()  %>">修  改</a>		
	</td>
</tr>
<%		
	}
}
%>
</table>

</div>
</div>
</article>
<footer>
Welcome To The Activity System
</footer>


</body>
</html>