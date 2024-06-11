<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<ul>
	<li><%= request.getRequestURL() %></li>
	<li><%= request.getProtocol() %></li>
	<li><%= request.getServerName() %></li>
	<li><%= request.getContextPath() %></li>
	<li><%= request.getQueryString() %></li> <!-- 주소창에서 ?이후를 queryString, page: parameterName, =1 : value  -->
	<li><%= request.getMethod()  %></li>
</ul>