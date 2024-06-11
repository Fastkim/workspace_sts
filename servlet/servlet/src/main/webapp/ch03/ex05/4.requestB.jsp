<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ page import='ch03.ex05.User' %>
<%
	User user = (User)request.getAttribute("user"); // User 타입의 파라미터를 넘겼지만 return타입은 Object이다.
%>
<jsp:forward page='4.requestC.jsp'/>