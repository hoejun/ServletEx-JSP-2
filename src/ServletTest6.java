import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest6 extends HttpServlet {
	/*
	 * (설명)
	 * 클라이언트 사용자가 get방식으로 서블릿을 요청하든!!!!!
	 * post방식으로 서블릿프로그램을 요청하든!! 상관없이 .... 만들어 보자.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doGet메소드 내부에서 doPost메소드 다시 호출하기
		doPost(req, resp);
	}

	
	//클라이언트가 doPost방식으로 서블릿 요청시 호출되는 메소드
	//하는일 : 요청값 받고 응답
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("Servlet Test......");
		
		/*설명: 요청한 클라이언트에 대한 정보는 resp에 들어있다.*/
		//클라이언트에게 출력(내보내기,응답하기)을 위해 한글깨짐을 방지하기위한 한글처리
		resp.setCharacterEncoding("euc-kr");
		
		//resp.getWriter()메소드를 이용하여.
		//클라이언트에 응답할 출력 객체인 PrintWriter객체 얻기
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("<h3>Request 정보 확인</h3>");
		out.println("<li>"+req.getMethod() +"</in>'"); //클라이언트의 요청방식 반환
		out.println("<li>"+req.getRequestURI() +"</in>'"); //요청한 클라이언트의 가상 주소 경로
		out.println("<li>"+req.getProtocol() +"</in>'"); //요청한 클라이언트의 프로토콜
		out.println("<li>"+req.getRemoteAddr() +"</in>'"); //웹서버에 현재 요청한 클라이언트의 ip주소 
		out.println("<hr/>");
		
		//getHeaderNames():
		//요청한 클라이언트의 정보 하나 하나를 담고 있는 각각의 변수 이름을?
		//Enumeration개체에 담아서 반환
		
		Enumeration e= req.getHeaderNames();
		
		//Enumeration개체에
		//요청한 클라이언트의 정보 하나 하나를 담고 있는 각각의 변수들이 있는 동안 반복
		while(e.hasMoreElements()){
			//요청한 클라이언트의 정보 하나하나를 담거 있나???...
			//Enumeration 객체에 첫번째 변수이름을 받아 저장
			String name = (String)e.nextElement();
			
			//첫번째 변수 name에 관한 헤더정보를 반환
			String value =req.getHeader(name);
			
			//클라이언트 요청 정보를 담고 있는 변수 name:실제 요청 정보 value
			out.println(name + "--->" + value + "<br/>");
			
		}
			
		out.println("</body></html>");
		
	}//doPost
	
}
