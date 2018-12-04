package test.servlet;
import java.io.*;

import javax.servlet.*;
//HttpServlet 클래스 상속받기 위해 import
import javax.servlet.http.*;

//서블릿 클래스 만들기
//1. 서버에서 실행되는 프로그램
//2. 클라이언트로 부터 요청받은 후 응답하는 서블릿 클래스

//서블릿 클래스를 만드려면, 먼저 HttpServlet클래스를 상속 받아야 함.

public class ServletTest2 extends HttpServlet{
	
	/*사용자의 요청을 받고 응답할 doGet()메소드 ...오버라이딩*/
	
	//클라이언트가 HttpServlet 프로그램으로 get방식으로 요청했을경우 호출됨.
	//데이터 요청 받은 후 응답함
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*클라이언트 요청 - 웹브라우저 요청!!, 요청시 var1변수에 java문자열을 넣어 요청*/
		//http://localhost:8000/ServletEx/.do?var1=java
		
		String var1=req.getParameter("var1");
		//클라이언트->서버에 데이터 요청할때.. 요청데이터 한글처리하기
		req.setCharacterEncoding("euc-kr");
		//서버->클라이언트 응답할때...한글처리
		resp.setCharacterEncoding("euc-kr");
		
		/*HttpServletletResponse객체는 요청한 클라이언트의 정보를 알고 있다.
		 * 그러므로 HttpServletResponse의 부모 인터페이스 ServletResponse에 있는
		 * getWriter()메소드를 상속받아 getWriter()메소드의 리턴 객체
		 * ->"PrintWriter" 객체를 통하여 클라이언트에게 데이터를 응답한다.
		 */
		PrintWriter out = resp.getWriter();
		
		//사용자에게 보여줄 HTML 디자인 태그를 서블릿 프로그램 내부에서 작성하기(불편함)
		out.println("<html><body>");
		out.println("<h1>"+var1+"를 전달 받았습니다.</h1>");
		out.println("</body></html>");
		
		out.close();
	
	
	
	
	}
	
	
	

}
