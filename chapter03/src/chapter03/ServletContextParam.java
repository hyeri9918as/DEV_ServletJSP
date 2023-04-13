package chapter03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ServletContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getServletContext() 메서드를 사용해 현재의 ServletContext 객체를 얻어온다. 
		ServletContext context = this.getServletContext();
		
		// getInitParameterNames() 메서드를 사용해 모든 ServletContext 파라미터의 이름을 추출해 Enumeration 타입으로 반환한다. 
		Enumeration<String> paramNames = context.getInitParameterNames();

		// getInitParameter() 메서드를 사용해 모든 ServletContext 파라미터의 name 값을 추출해 출력한다. 
		while(paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			String value = context.getInitParameter(name);
			out.print(name + " : " + value + "<br>");
		}
	}

}
