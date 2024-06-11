<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%
	pageContext.setAttribute("username", "최한석"); // attribute는 session, page 등등에 담을수있지만 request는 parameter에만 담을수있음.
%>
${username} <br>
${hello} <br> <!-- null은 깨끗 -->
${empty hello} <br> <!-- null값인지 확인 -->
${empty username ? "무명" : username} <br> <!-- el의목적은 response에 empty나 text를 넣는것 -->

${!empty username ? username : "무명"} <br>