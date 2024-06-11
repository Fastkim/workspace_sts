<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<a href='main.html'>메인</a>
<%
	Cookie cookie = new Cookie("age", ""); // expire가 session이므로 로그아웃하기전까지는 살아남는다.
	cookie.setMaxAge(0); // expire를 0으로 변경하였다.
	
	response.addCookie(cookie);
%>