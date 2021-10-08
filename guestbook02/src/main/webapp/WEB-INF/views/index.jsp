<%@page import="java.sql.Date"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVO"%>
<%@page import="java.util.List"%>
<%@page import="com.douzone.guestbook.dao.GuestbookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	GuestbookDAO dao = new GuestbookDAO();
	List<GuestbookVO> list = dao.findAll();

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook02/gb?link=join" method="post">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			<td>비밀번호</td><td><input type="password" name="password"></td>
<!-- 			<input type="hidden" name="regDate" value=""></td> -->
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<%
		int i=1;
		for(GuestbookVO vo : list) {
	%>
	<table width=510 border=1>
		<tr>
			<td>[<%=i %>]</td>
			<td><%=vo.getName() %></td>
			<td><%= vo.getRegDate() %></td>
<%-- 			<td><a href="deleteform.jsp?no=<%=vo.getNo() %>">삭제</a></td> --%>
			<td><a href="/guestbook02/gb?link=deleteform&no=<%=vo.getNo() %>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage() %></td>
		</tr>
	</table>
	<br>
	<%
		i++;}
	%>
</body>
</html>