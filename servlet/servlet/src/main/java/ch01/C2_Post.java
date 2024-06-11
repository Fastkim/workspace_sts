package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ch01/post/add") // 앱상(/servlet)에서 유일해야한다.
public class C2_Post extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException { // request, response객체는 tomcat이 가지고있는 VM이 만든다.
		int num1 = 1;
		int num2 = 2;
		
		response.setContentType("text/html; charset=utf-8"); // 크롬(브라우저)에게 전달 자기가 받은 text가 html임을 인지한다.
		PrintWriter out = response.getWriter();
		out.println("<h2>POST</h2>");
		out.printf("<p>%d + %d = %d</p>", num1, num2, num1 + num2);
	}
}
