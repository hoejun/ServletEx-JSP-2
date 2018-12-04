package test.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.jasper.tagplugins.jstl.core.*;

import com.sun.org.apache.xml.internal.serializer.*;

public class ServletTest5 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글처리
		req.setCharacterEncoding("euc-kr");
		resp.setCharacterEncoding("euc-kr");

		// 클라이언트에게 응답하기 위한 출력 객체 얻기
		PrintWriter out = resp.getWriter();

		// 체크박스로 부터 체크된 값들을 하나의 hobby이름으로 전달받는다.
		// 전달받을시 체크된 값들을 배열 형태로 받는다.
		// String[] chk = req.getParameterValues("hobby");

		out.println("<html><body>");

		// <form>태그에 있는 모든 name 속성의 변수이름들을 Enumeration객체에 모두 넣어서...
		// Enumeration객체 자체를 반환한다.
		Enumeration<String> en = req.getParameterNames();

		// 설명
		// 그럼 현재 위의 Enumeration객체에 있는 <form>태그의 name에 해당하는 변수들이...
		// 모두다 저장되어 있을것이다.
		/* Enumeration객체에 <form>태그의 name에 해당하는 변수 이름이 존재하는 동안 반복 */
		while (en.hasMoreElements()) {

			// <form>태그의 name에 해당하는 변수이름 반환
			// ->맨처음에 체크박스 변수이름 hobby 변수이름 반환
			String name = en.nextElement();

			/* 체크박스 요청받고 응답 처리 */
			if (name.equals("hobby")) {// 체크한것이 체크박스면?
				// 체크박스에 체크된 항목만 배열로 리턴 받아오기
				String[] chk = req.getParameterValues(name);
				//만약 체크박에서 체크된 값이 하나라도 있다면?
				if(chk != null){
					for(int i=0; i<chk.length; i++){
						//체크된 값 하나씩 출력
						out.println("<li>" + chk[i] + "</li>");
						
					}
				}else{//만약 체크박스에서 체크된 값이 없다면?
					out.println("선택한 값이 없습니다.");
					
				}
				
			} else if (name.equals("gender")) {// 체크한것이 성별 레디오 버튼이면?
				
			String gender =	req.getParameter(name);
			
			//선택한 라디오 버튼 출력
			out.println("<li>" +gender + "</li>");
			
			} else {// 체크한것이 주거지 라디오 버튼이면?
				String area =	req.getParameter(name);
				
				//선택한 라디오 버튼 출력
				out.println("<li>" +area + "</li>");
				
			}
		}
		out.println("</body></html>");

	}
}
