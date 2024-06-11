<%@ page language='java' contentType='text/html; charset=utf-8' pageEncoding='utf-8' %>
<%@ page import='ch05.service.TodayService, ch05.service.TodayServiceImpl' %>
<%@ page import='ch05.service.EmployeeService,ch05.service.EmployeeServiceImpl' %>
<%
TodayService todayService = new TodayServiceImpl();
%>
<%=todayService.getToday()%>

<%
EmployeeService selectService = new EmployeeServiceImpl();
%>
<%= selectService.getEmployee(100) %>
