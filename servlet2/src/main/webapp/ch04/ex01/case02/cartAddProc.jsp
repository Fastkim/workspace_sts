<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%
	String[] products = request.getParameterValues("product");

	if(products != null) {
		String cart = "";
		for(String product: products) cart += product + "/";
		
		Cookie cookie = new Cookie("cart", cart);
		cookie.setMaxAge(60 * 60 * 24 * 7); //scope를 일주일로 준다.
		response.addCookie(cookie); // 설정된 쿠키를 response에 담는다.
	}
%>
<c:redirect url='cartOut.jsp'/>