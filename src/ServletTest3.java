import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest3 extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    //첫번째 실습 
    //ServletRequest객체에 있는 getParameter()메소드 호출하여...
    //클라이언트가 웹브라우저를 통해 서블릿에게 전송한 데이터 하나씩 받아오기 
    String irum = req.getParameter("irum");
    String addr = req.getParameter("addr");
        
        
    /*두번째 실습*/
    //ServletRequest객체에 있는 getOaramterValues()메소드를 호출하여 ...
    //클라이언트가 웹브라우저를 통해 서블릿에게 전송한 많은 데이터를
    //한꺼번에  데이터 배열로 받아오기 
    String[] var = req.getParameterValues("var");
    
    //요청 받는 데이타 한글처리 (한글이 깨져보이지 않게 하기 위함)
    req.setCharacterEncoding("UTF-8");
    //응답 하는  데이타 한글처리 (한글이 깨져보이지 않게 하기 위함)
    resp.setCharacterEncoding("UTF-8");
        
        
        PrintWriter out = resp.getWriter();
        
        //첫번째 실습
        //사용자에게 보여줄 HTML디자인 태그를 서블릿프로그램 내부에서 작성하기 (불편함)
        out.println("<html><body>");
        out.println("<h1>" + irum + "를 전달 받았습니다.</h1>");
        out.println("<h1>" + addr + "를 전달 받았습니다.</h1>");
        out.println("</body></html>");
        
        //두번째 실습
        // 사용자에게 보여줄 HTML디자인 태그를 서블릿프로그램 내부에서 작성하기 (불편함)
        out.println("<html><body>");
        out.println("<h1>" + var[0] + "를 전달 받았습니다.</h1>");
        out.println("<h1>" + var[1] + "를 전달 받았습니다.</h1>");
        out.println("</body></html>");
           
        out.close();
       
    }
    
}
