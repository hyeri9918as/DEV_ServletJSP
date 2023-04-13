package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 파라미터가 추가된 @WebServlet 애너테이션 )- 전역변수 생성 / 다른 서블릿에서 참조 불가 
@WebServlet(
		description = "파라미터 지정", 
		urlPatterns = { "/scf1" }, 
		initParams = { 
				@WebInitParam(name = "username", value = "홍길동"), 
				@WebInitParam(name = "usercompany", value = "한국주식회사")
		})

public class ServletConfigInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
    	// 응답으로 내보낼 출력 스트림을 얻는 과정 
		PrintWriter out = response.getWriter();
		
		// getInitParameter() 메서드를 사용해 모든 ServletContext 파라미터의 name 값을 추출해 출력한다. 
		String name = getInitParameter("username");
		String company = getInitParameter("usercompany");
		
		out.print(name + ":" + company);
		
	}

}
