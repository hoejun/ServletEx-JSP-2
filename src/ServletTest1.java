import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

//서블릿 클래스 만들기:
//1. 서버에서 실행되는 프로그램
//2. 클라이언트로 부터 요청 받은후 응답하는 서블릿 프로그램

//서블릿클래스를 만들려면 먼저 HttpServlet클래스를 상속 받아야 한다.

public class ServletTest1 extends HttpServlet{

	//alt + shift + s + v 메소드 오버라이딩(매소드 구현부 재구현) 
	
	/*사용자의 요청을 받을 메소드들... 오버라이딩 */
	
	//사용자가 HttpServlet프로그램으로 get방식으로 요청했을경우 호출됨. 요청받기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //super.doGet(req, resp);
		System.out.println("Servlet Get방식 요청 성공");		
	}

	//사용자가 HttpServlet프로그램으로 Post방식으로 요청 했을경우 호출됨. 요청받기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    //super.doPost(req, resp);
	
		System.out.println("Servlet Post방식 요청 성공");
	}

}
