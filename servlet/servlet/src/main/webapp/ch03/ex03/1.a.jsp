<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
A
<%
	// dispatcher가 request를 보낸다.
	// client request -> A -> B -> client response (삼각형구조)
	// A forward B 관계
	// B는 A의 response를 모두 받는다. (상속개념)
	RequestDispatcher dispatcher = request.getRequestDispatcher("1.b.jsp");
	dispatcher.forward(request, response);
%>