<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<form action='4.numOut.jsp' method='post'>
	<input type='number' name='num'/>
	<input type='submit'/>
</form>
<%
	String msg = request.getParameter("msg");
%>
<%= msg != null ? msg : "" %>