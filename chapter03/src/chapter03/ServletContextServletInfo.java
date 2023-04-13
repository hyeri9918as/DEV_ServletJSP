package chapter03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scinfo")
public class ServletContextServletInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
    	// 응답으로 내보낼 출력 스트림을 얻는 과정 
		PrintWriter out = response.getWriter();
		// getServletContext() 메서드를 사용해 현재의 ServletContext 객체를 얻어온다. 
		ServletContext sc = this.getServletContext();
		
		// getMajorVersion() : 현재 서블릿의 Major 버전을 반환한다. 
		out.print("서블릿 버전 : " + sc.getMajorVersion() + "." + sc.getMinorVersion() + "<br>");
		out.print("서버 정보 : " + sc.getServerInfo() + "<br>");      // 서블릿의 컨테이너의 이름과 버전 정보를 반환 
		out.print("애플리케이션 경로 : " + sc.getContextPath() + "<br>");     // 애플리케이션의 경로를 반환 
		out.print("애플리케이션 이름 : " + sc.getServletContextName() + "<br>");    // ServletContext의 이름을 반환 
		out.print("파일의 실제 경로 : " + sc.getRealPath("/"));   // 인자로 지정된 path의 현재 실제 경로를 반환
	}
}
