<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<ol>
	<li>${scope}</li> <!-- requestScope: default -->
	<li>${pageScope.scope} </li> <!-- pageContext는 해당페이지에서만 값을 전달하기때문에 null이다. -->
	<li>${requestScope.scope } </li>
	<li>${sessionScope.scope } </li>
	<li>${applicationScope.scope }</li>
</ol>