<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>

${fruit} <br> <!-- 요청scope이 아무것도 없으면 null 반환 -->
${pageScope.fruit} <br>
${requestScope.fruit} <br>
${sessionScope.fruit} <br>
${applicationScope.fruit} <br>
