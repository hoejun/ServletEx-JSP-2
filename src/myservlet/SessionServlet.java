package myservlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//응답 출력 정보 한글처리
		resp.setCharacterEncoding("euc-kr");
		//요청 정보 한글처리
		req.setCharacterEncoding("euc-kr");
		
		//클라이언트 요청 irum받기
		String newirum = req.getParameter("irum");
		
		/*
		 * 클라이언트로 부터 요청받았다면 request객체가 생성되어 매개변수로 받고...
		 * 또한~ request객체 내부에는????
		 * 요청한 클라이언트에 대한 Session객체 메모리가 자동으로 생성된다.
		 */
		
		//클라이언트로 부 터 요청받은 request객체 내부에 있는 Session객체를 얻어온다.
		HttpSession session = req.getSession(true);
		
		//클라이언트로 부터 요청받은 newirum변수의 값을 다른 "sessionirum"변수에 저장하면서
		//Session객체 내부에.. 데이터를 저장시킨다.
		session.setAttribute("sessionirum", newirum);
		
		//클라이언트 브라우저 화면에 출력할 출력객체
		PrintWriter out =	resp.getWriter();	
		
    	//Session 객체 내부에 저장되어 있는 클라이언트가 요청한 세션 데이터를 꺼내어서.
    	//클라이언트의 브라우저에 출력 해준다.
    	out.println(session.getAttribute("sessionirum"));
    
    	//Session객체 내부에 저장되어 있는 클라이언트가 요청한 세션 id 데이터를 꺼내어서,,,,.
    	//클라이언트의 브라우저에 출력 해준다.
    	out.println(session.getId());
    	
    	//Session객체 내부에 저장되어 있는 클라이언트가 요청한 세션요청시간을 꺼내어서....
    	//클라이언트의 브라우저에 출력해준다...
    	//저웃형태로 나온시간을 날짜형태로 변경함,..,, Date로 감싼다.
    	out.println(new Date(session.getCreationTime()) );
    	
    	//Session객체 내부에 저장되어 있는 클라이언트의 세션 유지시간(접속시간)을 꺼내어서...
    	//클라이언트의 브라우저의 출력 해준다.
    	out.println(session.getMaxInactiveInterval());
		
	}

	
}
