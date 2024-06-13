<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<form method='post' encType='multipart/form-data'> <!-- encType(encoding Type) 따로 기재안하면 기본값 -->
	<label>이름: <input type='text' name='username'/></label><br>
	<label>나이: <input type='number' name='age'/></label><br>
	<label>얼굴: <input type='file' name='face'/></label> <!-- 이것때문에 method=post, encType을 설정한것이다. -->
	<input type='submit'/>
</form>