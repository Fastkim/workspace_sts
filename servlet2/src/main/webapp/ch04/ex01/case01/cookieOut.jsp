<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<a href='main.html'>메인</a><br>
<%
	Cookie[] cookies = request.getCookies();

	for(Cookie cookie: cookies) {
		if(cookie.getName().equals("username") || cookie.getName().equals("age")) {
%>			
			<%= cookie.getName() %>: <%= cookie.getValue() %><br>
<%			
		}
	}
%>