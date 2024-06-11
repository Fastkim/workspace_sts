package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ch01/getPost/add")
public class C3_GetPost extends HttpServlet {
	// doGet과 doPost를 같이썻을때 중복을 제거해보자
	// 아래 코드의 단점: 자바코드와 html코드가 뒤죽박죽 섞여있다 -> 스파게티코드
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		int num1 = 1;
		int num2 = 2;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.println("<h2>" + request.getMethod() + "</h2>");
		out.printf("<p>%d + %d = %d</p>", num1, num2, num1 + num2);
	}
	
	
	/*
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // tomcat안에 JVM이 있으므로 tomcat이 받고 JVM이 받는다.
			int num1 = 1;
			int num2 = 2;
			
			response.setContentType("text/html; charset=utf-8"); //url을 알려주고 encoding을 알려준다. http test는 physical 하게 text이지만 logical 하게는 content이다.
			PrintWriter out = response.getWriter();
			out.println("<h2>GET</h2>"); // out객체 집어넣고 response 안에 들어간다, tomcat에 response를 보내주고 tomcat이 처리한다.
			out.printf("<p>%d + %d = %d</p>", num1, num2, num1 + num2);
	}
	
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
	*/
}
