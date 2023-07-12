<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.*,java.util.*" %>
    <%
	List<Entry> list =(List<Entry>)application.getAttribute("list");
    String msg =(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(msg != null){ %>
<p><%=msg %></p>
<%} %>
<form action="Process" method="post">
製品名:<input type="text" name="name"><br>
価格:<input type="text" name="price"><br>
<input type="submit" value="登録">
</form>
<%if (list.size()>0){ %>
<table border="1">
<tr><th>製品名</th><th>価格</th><th>登録日</th></tr>
<%for (Entry e :list){ %>
<tr>
<td><%=e.getName() %></td>
<td><%=e.getPrice() %></td>
<td><%=e.getDateTime() %></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>