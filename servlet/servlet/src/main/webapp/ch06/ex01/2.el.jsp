<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
String: ${"hello"} <br>
int: ${10} <br>
double: ${10.0} <br>
boolean: ${true} <br>
null: ${null} <%-- <%= null --%> <br> <!-- expression은 null값에 대해 exception으로 처리함. -->

\${5 * 2}: ${ 5 * 2 } <br>
${ 5 > 2 } <br>
${ 5 > 2 ? 5 : 2 } <br>
${ 5 > 2 || 5 < 2 } <br>