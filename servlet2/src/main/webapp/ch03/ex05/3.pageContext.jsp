<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ page import='ch03.ex05.User' %>
<%
	pageContext.setAttribute("user", new User("최한석", 12));
	User user = new User("한아름", 42); // JSPservice의 localvariable
%>
<!-- 과제: 최한석과 한아름을 출력하라. -->
<%= pageContext.getAttribute("user")%><br>
<%= user %>