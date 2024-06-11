<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
B

<!--  
	셋다 페이지이동에 관련된것.

	A forward B request 1번 response 1번 
	client request -> A -> B -> client response

	A include B
	client request -> A -> B -> A -> client response
	
	A redirect B
	client request -> A response -> client request -> B -> client response
	A와 B간의 서로 다른서버에 있을경우
	A와 B의 페이지가 서로 다를경우
	네이버에 youtube링크가 있을경우
 -->