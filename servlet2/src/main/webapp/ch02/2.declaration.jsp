<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<!--  이 밑에 내용은 servlet의 jspService 메서드의 body이다. -->
<%! // jspService 메서드의 body가 아니라 또다른 member method를 만들고 싶다 -> <%!~ = declaration(선언)
	// declaration 문법은 잘 사용하지않음.
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	int num1 = 1;
%>
<% // jspService의 body
	int num2 = 2;
%>

<%= num1 %> + <%= num2 %> = <%= add(num1, num2) %> <!-- expression도 jspService의 body -->
<!--  2.declaration.java 파일은 tomcat에게 request를 보냈을때 생성된다. -->
<!--  jsp페이지를 바탕으로 만들어진 servlet이 request를 받는다. -->