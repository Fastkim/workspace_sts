<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%
	String[] letters = request.getParameterValues("letter");
	String gender = request.getParameter("gender");
	String[] jobs = request.getParameterValues("job");
%>
<%-- 과제: letters를 iteration 해서 출력하라. JSP만의 주석문법 --%>
<%
	if(letters != null)
		for(String letter : letters) {
%>
			<%= letter %> &nbsp;
<%
	 }
%>

<%= gender %> <br>

<%
	if(jobs != null)
		for(String job : jobs) {
%>
			<%= job %> &nbsp;
<%
		}
%>