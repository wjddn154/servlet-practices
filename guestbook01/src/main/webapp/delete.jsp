<%@page import="com.douzone.guestbook.vo.GuestbookVO"%>
<%@page import="com.douzone.guestbook.dao.GuestbookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	String password = request.getParameter("password");
	
	new GuestbookDAO().delete(Long.parseLong(no), password);
	
	response.sendRedirect("/guestbook01");

%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>