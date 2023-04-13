package chapter03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scget")
public class ServletContextGetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	response.setContentType("text/html;charset=utf-8");
    	
    	// 응답으로 내보낼 출력 스트림을 얻는 과정 
		PrintWriter out = response.getWriter();
		
		// getServletContext() 메서드를 사용해 현재의 ServletContext 객체를 얻어온다. 
		ServletContext context = this.getServletContext();
		
		// getAttribute(String name) : 바인딩 되어 있는 name 속성 값을 추출 (ArrayList) 값을 불러옴)
		List person = (ArrayList)context.getAttribute("person");
		String user_name = (String) person.get(0);   // user_name 객체에 person0번 인덱스 값을 가져옴 
		String user_company = (String) person.get(1);   // user_company 객체에 person 1번 인덱스 값을 가져옴 
		
		// user_city 객체에 city 속성값을 가져옴 
		String user_city = (String) context.getAttribute("city");
		
		out.print(user_name + ":" + user_company + "<br>");
		out.print(user_city);
	}

}
