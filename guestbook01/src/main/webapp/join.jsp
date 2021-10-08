<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.douzone.guestbook.dao.GuestbookDAO"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String message = request.getParameter("message");

	Timestamp ts=new Timestamp(System.currentTimeMillis());  
    Date date=new Date(ts.getTime());  
	
	
	GuestbookVO vo = new GuestbookVO();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	vo.setRegDate(date);
	
	new GuestbookDAO().insert(vo);
	
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