<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<c:choose>
	<c:when test='${agree == "yes" }'>
		합니다.
	</c:when>
	<c:otherwise>
		안합니다.
	</c:otherwise>
</c:choose>