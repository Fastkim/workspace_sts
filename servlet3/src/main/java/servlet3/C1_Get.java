package servlet3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 기본 타입은 GET 타입이다.
@WebServlet("/ch01/get/add")
public class C1_Get extends HttpServlet { // HttpServlet: Http에 관련된 알고리즘을 구현한 메서드를 가지고 있는 클래스이다.
	// 기술 로직은 httpServlet에 알고리즘으로 다 구현되어있으니
	// 업무에 관련된 비즈니스 로직(택배, 서점, 쇼핑)에 우리는 집중하면된다.
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException { // tomcat안에 JVM이 있으므로 tomcat이 받고 JVM이 받는다.
		int num1 = 1;
		int num2 = 2;
		
		//url을 알려주고 encoding을 알려준다. http text는 physical 하게는 text이지만 logical 하게는 content이다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h2>GET</h2>")
	}
	
}
