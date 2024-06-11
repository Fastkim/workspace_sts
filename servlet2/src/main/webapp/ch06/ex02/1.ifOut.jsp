<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<c:if test='${param.color == 1}'>빨강</c:if>
<c:if test='${param.color == 2}'>노랑</c:if>
<c:if test='${param.color == 3}'>파랑</c:if>
<c:if test='${param.color == 1}'>RED</c:if> <!-- 동일한 if문은 n개만큼 생성할수있다. -->
<!-- 알고리즘에는 el사용 부적절 -->
<!-- response를 화면에 출력하는 용도로는 적절 -->
<!-- if -->