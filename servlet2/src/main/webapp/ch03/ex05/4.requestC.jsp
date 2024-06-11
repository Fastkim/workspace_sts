<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%= request.getAttribute("user") %>	

<!-- 
	request로 page간의 데이터이동방법
	1. request.getParameter (client가 데이터 생성)
	2. request.getAttribute (server가 데이터 생성)
 -->