<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<ul>
	<c:forEach var='fruit' items='${paramValues.fruit}' varStatus='st'>
		<li>${st.count}: ${fruit}, ${st.index}</li>
	</c:forEach>
</ul>
<!-- 
st.count : 고객 관점 
st.index : 개발자 관점
-->