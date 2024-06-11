<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%
	pageContext.setAttribute("one", "페이지");
	request.setAttribute("two", "리퀘스트");
	// parameter는 클라이언트가 데이터 생성, attribute는 server가 데이터 생성
	// parameter의 value type은 text, attribute value type은 object
	session.setAttribute("three", "세션");
	// 논리적인 연결 : session 객체, 객체가 있으면 연결상태, 객체가 없으면 해제상태
	// ex) 장바구니 -> sessionScope
	// ex) 운동화 페이지 접속 -> requestScope
	application.setAttribute("four", "애플리케이션");
	
	// contextScope < requestScope < sessionScope < applicationScope
%>
<c:redirect url='1.scopeB.jsp'/>