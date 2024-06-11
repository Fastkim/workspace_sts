<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ page import='ch06.ex01.User' %>
<%@ page import='java.time.LocalDate' %>
<%
	pageContext.setAttribute("user", new User(1, "최한석", LocalDate.of(2024, 6, 4)));
	request.setAttribute("user", new User(2, "한아름", LocalDate.of(2024, 6, 15)));
	session.setAttribute("user", new User(3, "양승일", LocalDate.of(2024, 12, 12)));
	application.setAttribute("user", new User(4, "김필진", LocalDate.of(2024, 12, 30)));
%>
<jsp:forward page='6.userOut.jsp'/>