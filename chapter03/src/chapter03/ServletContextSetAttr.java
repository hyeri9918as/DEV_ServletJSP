package chapter03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/scset")
public class ServletContextSetAttr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		// getServletContext() 메서드를 사용해 현재의 ServletContext 객체를 얻어온다. 
		ServletContext context = getServletContext();
		
		//ArrayList는 List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트
		List person = new ArrayList();
		
		// add 메서드 : ArrayList에 값을 추가하는 메서드
		person.add("이순신");
		person.add("코리아시스템");
		
		// setAttribute(String name, Object object): object를 name이라는 속성으로 바인딩 
		context.setAttribute("person", person);
		context.setAttribute("city", "서울");
	}

}
