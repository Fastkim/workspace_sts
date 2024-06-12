<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ page import='java.util.List, java.util.ArrayList' %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%
	String[] products = request.getParameterValues("product");

	if(products != null && products.length > 0) {
		List<String> cart = new ArrayList<>();
		
		for(String product: products)
			cart.add(product);
		
		session.setAttribute("cart", cart);
	}
%>
<c:redirect url='cartOut.jsp'/>

<!-- 
	forward: 같은서버에 있어야함, client가 관여안함 
	redirect: 다른서버에 있어도 됨, client가 관여함.
-->

