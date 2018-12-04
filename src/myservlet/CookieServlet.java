package myservlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CookieServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	    //응답 데이터의 데이터 타입을 HTML타입의 데이터로 지정
		resp.setContentType("text/html");
		
		//서버가 -> 클라이언트에 응답할때 응답데이터 한글 처리하기 
		resp.setCharacterEncoding("EUC-kr");
		
		//클라이언트 브라우저 화면에 출력할 출력객체
		PrintWriter out = resp.getWriter();
		
		//클라이언트 요청방식이 get방식과 같다면 요청받은 name과 addr의 값을 쿠키에 저장
		if(req.getMethod().equals("GET")){
			//클라이언트로 부터 요청받은 내용을 받아온다.
			String name =  req.getParameter("name");
			String addr =  req.getParameter("addr");
			
			if(name != null && addr != null){
				//클라이언트의 컴퓨터 하드디스크에  "toname"이라는 변수를 만들어서
				//name변수값(쿠키값)을 저장할 쿠키 객체 생성.
			    Cookie nameCook =	new Cookie("toname", name);
			
			    //클라이언트의 컴퓨터 하드디스크에 하루동안 쿠키값 저장할 시간 셋팅
			    nameCook.setMaxAge(60*60*24);
		
			    //클라이언트의 컴퓨터 하드디스크에 "toaddr"이라는 변수를 만들어서....
			    //addr변수값(쿠키값)을 저장할 쿠키 객체 생성.
			    Cookie addrCook = new Cookie("toaddr", addr);
		
			    //클라이언트의 컴퓨터 하드디스크에 하루 동안 쿠키값 저장할 시간 셋팅
			    addrCook.setMaxAge(60*60*24);
		
			    //실제 클라이언트로 응답하기 위한 객체 response객체에 쿠키객체를 추가
			    resp.addCookie(nameCook);
			    resp.addCookie(addrCook);
		
			    out.println("쿠키가 서블릿내부의 response객체에 저장되었음.");
		
		
			}
			//클라이언트가 html파일로 또다시 서블릿으로 요청이 들어온다면?(여기서는 POST요청함)
		}else{
			//클라이언트의 웹브라우저로부터 요청받은.......
			//request객체 실려온 쿠키객체의 값을 꺼내서 Cookie[]배열에 넣어 반환한다.
			Cookie[] cooks =req.getCookies();
			
			//반복문 이용하여 cooks배열에 들어 있는 원하는 쿠키정보를 얻는다.
			for(int i=0; i<cooks.length; i++){
				Cookie c=cooks[i];
				//쿠키 변수 이름 꺼내오기
				String name = c.getName();
				//쿠키 변수이름에 대한 값 꺼내오기
				String value = c.getValue();
				out.println(name + ":" + value);
				
			}
			
		}
		
	}

}
