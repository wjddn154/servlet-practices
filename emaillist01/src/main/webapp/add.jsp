<%@page import="com.douzone.emaillist.dao.EmaillistDAO"%>
<%@page import="com.douzone.emaillist.vo.EmaillistVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");

	EmaillistVO vo = new EmaillistVO();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	new EmaillistDAO().insert(vo);
	
	response.sendRedirect("/emaillist01");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>성공적으로 등록되었습니다!</h1>
</body>
</html>