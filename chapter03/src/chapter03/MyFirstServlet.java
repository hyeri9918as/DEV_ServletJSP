package chapter03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// MyFirstServlet은 HttpServlet을 상속받는다.
public class MyFirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	// 16번 라인부터 18번 라인은 init 메서드 구현 / servlet 생성시 단 한번 실행  
	public void init() throws ServletException {
		System.out.println("init 메서드가 수행되었습니다.");
	}
	
	// 22번 라인부터 25번 라인은 doGet 메서드 구현 /doPost와 doGet 중 기본값은 doGet 
	// doGet은 HttpServletRequest와 HttpServletResponse 객체를 service로부터 전달 받음 
	protected void doGet(HttpServletRequest req, HttpServletResponse res)    
			throws ServletException, IOException {
		System.out.println("doGet 메서드가 수행되었습니다.");
	}
	
	// 28번 라인부터 30번 라인은 destroy 메서드 구현 / 웹 서버 종료시 단 한번 실행 
	public void destroy() {
		System.out.println("destroy 메서드가 수행되었습니다.");
	}
	
}
