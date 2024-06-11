package ch01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 기본 타입은 GET 타입이다.
@WebServlet("/ch01/get/add") // 고유 URL 주소
public class C1_Get extends HttpServlet { // HttpServlet: Http에 관련된 알고리즘을 구현한 메서드를 가지고 있는 클래스이다.
	// 기술 로직은 httpServlet에 알고리즘으로 다 구현되어있으니
	// 업무에 관련된 비즈니스 로직(택배, 서점, 쇼핑)에 우리는 집중하면된다. 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException { // tomcat안에 JVM이 있으므로 tomcat이 받고 JVM이 받는다.
		int num1 = 1;
		int num2 = 2;
		
		//url을 알려주고 encoding을 알려준다. http test는 physical 하게는 text이지만 logical 하게는 content이다.
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println("<h2>GET</h2>"); // out객체 집어넣고 response 안에 들어간다, tomcat에 response를 보내주고 tomcat이 처리한다.
		out.printf("<p>%d + %d = %d</p>", num1, num2, num1 + num2);
		// Get: 읽겠다(read), Post: 쓰겠다(write), 인터넷상에서의 대부분 request type은 Get타입이다.
		// 대부분의 유저는 get타입을 요청한다.
		// 클라이언트(크롬) URL(http(프로토콜이름)://도메인이름(문자), ip주소(숫자), 포트번호(80){생략}, 기본포트번호(80)와 다르다면 직접입력해줘야한다.
		// -> 노드(machine) -> tomcat(포트넘버로 찾아감)
		// tomcat server, oracle server가 돌아가고 있다. request는 동일한 컴퓨터(노드)에 도달하고 포트번호로 두개의 서버중 어디로 보낼지 정하는것이다.
		// tomcat server: 80, oracle server: 1521(포트번호)
		// tomcat에 도달했으면 tomcat 내부의 여러앱이 있는데 거기서는 설정된 URL을 보고 찾아간다.
		// 즉, tomcat 내부의 각 앱(노드 객체)의 URL을 찾아간다.
		// 즉, 최종 URL은 http(시작)~ /ch01/get/add로 끝난다.
		// doGet 메서드는 tomcat이 호출한다.
		// tomcat이 요청을 처리하고 맵핑하는 역할.
		// request 타입이 Get타입이면 doGet을 call한다.
		// http에서는 text로 표현, java에서는 객체로 표현 (요청받은 데이터집합)
		// or-mapong: physical한 데이터의 차이점을 매꾸려고 사용 (physical한 데이터 -> oralce은 레코드, java는 객체)
		// tomcat http text타입의 request를 request객체로 만들어서 처리, 즉 tomcat도 or-maping을 수행하고 있는것이다.
		// http servlet type 객체
		// C1_Get 클래스(객체)는 httpServlet, Object,
		// request가 올때 작동한다. tomcat이 doGet, doPost를 call한다.
		// 알고리즘의 최종목표(servlet의 최종결과물)는 request에 대한 response를 만드는것이다.
		// server에서 client에 보내는 데이터집합, 단 request에 대한 데이터집합(response)이어야한다.
		// 또 http text는 HTML로 표현되어 저장된다, 즉 response는 HTML로 작성된다.
		// servlet에서 하는일은 request에 맞는 HTML Code를 작성하는것.
		// node.js : 브라우저의 javaScript를 빼내온것.
		// 브라우저의 어떤 엔진을 설치해놓느냐에 따라 언어를 이해할 수 있다.
		// 자바코드를 브라우저가 이해하려면 JVM 엔진이 있으면된다.
		
		// doGet메서드에서 발생한 Exception을 내가 처리하지않고 떠넘긴다. throws
		// tomcat이 실행되면 내부의 servlet 앱도 같이 실행된다.
	}
}
