<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*" %>
<%
String name="湊　雄介";
int age =20;
%>
<%
int x =10;
int y = 20;
%>
<%-- コメント --%>
<!-- htmlコメント -->
<%
int z = x + y;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>私の名前は<%=name %>。年齢は<%=age%>です。</p>
<p><%=z %></p>
<%for(int i =0;i<5;i++){ %>
<p><%=i %></p>
<%} %>
<table border="1">
<%for(int i =1;i<=9;i++){ %>
<tr>
<%for(int j=1;j<=9;j++){ %>
<td><%=i*j%></td>
<%} %>
</tr>
<%} %>
</table>
</body>
</html>