<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<form action='loginProc.jsp' method='post'>
	ID: <input type='text' name='userId'/><br>
	PW: <input type='password' name='pw'/><br>
	<button type='submit'>로그인</button>
</form>
<%
	String errorMsg = request.getParameter("msg");
	if(errorMsg != null) out.println(errorMsg);
%>
