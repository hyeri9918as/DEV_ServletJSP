package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// description : 설명 , urlPatterns : 매핑 이름을 지정 
@WebServlet(description = "두번째 서블릿", urlPatterns = { "/Second" })
public class MySecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Second</title>");
		out.println("<body>");
		out.println("<h2>두번째 서블릿입니다.</h2>");
		out.println("</body>");
		out.println("</head>");
		out.println("</html>");
		
	}

	// 사용자가 doPost로 요청할 때 doGet으로 응답하고자 할 때 사용하는 코드 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
