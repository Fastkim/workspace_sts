<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<form method='post'> <!-- request url과 response url이 같으면 생략가능 -->
	<label>이름: <input type='text' name='username'/></label>
	<label>나이: <input type='number' name='age'/></label>
	<label>등록일: <input type='date' name='regDate'/></label>
	<input type='submit'/>
</form>