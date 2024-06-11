<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<% 
	String username = request.getParameter("username");
	String age = request.getParameter("age");
	String birthday = request.getParameter("birthday");
%> <!-- request에 담기는 데이터의타입은 text이므로 String으로 받는다. -->
<h3>사용자</h3>
<ul>
	<li>이름: <%= username %></li>
	<li>나이: <%= age %></li>
	<li>생일: <%= birthday %></li>
</ul>