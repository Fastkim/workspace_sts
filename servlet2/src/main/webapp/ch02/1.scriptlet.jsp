<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<!--  contentType: 브라우저 읽으라고준 정보, pageEncoding: tomcat 읽으라고 준 정보  -->
<% // scriptlet : <%~, directive: <%@~
	int num1 = 1;
	int num2 = 2;
%>
<h2>더하기</h2>
<%= num1 %> + <%= num2 %> = <%= num1 + num2 %> <!-- expression -->
<!-- file: 물리적인관점, page: 논리적인관점 -->
<!-- html코드 안에 java코드를 넣는게 더 편하다. -->