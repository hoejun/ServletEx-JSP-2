package test.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest4 extends HttpServlet {

	//사용자가 HttpServlet프로그램으로 get방식으로 요청 했을경우 호출됨
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트 -> 서버에 데이터 요청할때 요청데이터 한글처리 하기
		req.setCharacterEncoding("EUC-KR");
		//서버->클라이언트 응답을 할때 한글처리 하기
		resp.setCharacterEncoding("EUC-KR");
		
		
		//클라이언트가 웹브라우저를 통해 서블릿에게 전송한 데이터 하나씩 받오기
		String irum=req.getParameter("irum");
		String addr=req.getParameter("addr");
		
		//PrintWriter객체를 통하여 클라이언트에게 데이터를 응답함.
		PrintWriter out=resp.getWriter();
		
		//사용자에게 보여줄 HTML디자인 태그를 서블릿프로그램 내부에서 작성하기(불편함)
		out.println("<html><body>");
		out.println("<h1>" + irum +"</h1>");
		out.println("<h1>" + addr +"</h1>");
		out.println("</body></html>");
	}
	
	//사용자가 HttpServlet프로그램으로 post방식으로 요청 했을경우 호출됨
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//클라이언트 -> 서버에 데이터 요청할때.. 요청 데이터 한글처리 하기
		req.setCharacterEncoding("EUC-KR");
		//서버가 -> 클라이언트에 응답할때.. 응답데이터 한글 처리 하기 
		resp.setCharacterEncoding("EUC-KR");
	
		
		//클라이언트가 웹브라우저를 통해 서블릿에게 전송한 데이터 하나씩 받오기
		String irum=req.getParameter("irum");
		String addr=req.getParameter("addr");
		
		//PrintWriter객체를 통하여 클라이언트에게 데이터를 응답함.
		PrintWriter out=resp.getWriter();
		
		//사용자에게 보여줄 HTML디자인 태그를 서블릿프로그램 내부에서 작성하기(불편함)
		out.println("<html><body>");
		out.println("<h1>" + irum +"</h1>");
		out.println("<h1>" + addr +"</h1>");
		out.println("Post방식으로 전송됨.");
		out.println("</body></html>");
		
	}

}
