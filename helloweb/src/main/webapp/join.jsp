<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String birthYear = request.getParameter("birthYear");
	String gender = request.getParameter("gender");
	String[] hobbies = request.getParameterValues("hobby");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=email %><br/>
	<%=password %><br/>
	<%=birthYear %><br/>
	<%=gender %><br/>
	
	<ul>
	<%
		for(String hobby : hobbies) {
	%>
		<li>
			<strong><%=hobby %></strong>
		</li>
		
	<%
		}
	%>
	</ul>


	<a href="form.jsp">폼으로 가기</a>
</body>
</html>