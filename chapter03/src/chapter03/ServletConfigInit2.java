package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigInit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
    	// 응답으로 내보낼 출력 스트림을 얻는 과정 
		PrintWriter out = response.getWriter();
		
		// getInitParameter() 메서드를 사용해 모든 ServletContext 파라미터의 name 값을 추출해 출력한다. 
		// web.xml 파일에 작성한 초기화 파라미터 값들을 불러온다. 
		String name = getInitParameter("user_name2");
		String company = getInitParameter("user_company2");
		
		out.print(name + ":" + company);
		
	}
}
