package study.jsp.helper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class BaseController
 */
//@WebServlet("/BaseController")
public abstract class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public Logger logger = null;
	
    public BaseController() {
       //실행되는 주체를 확인하기 위해서 클래스이름을 콘솔에 출력한다
    	String className = this.getClass().getName();
    	//System.out.println(className);
    	
    	logger = LogManager.getLogger(className);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통처리 메서드로 제어를 이동시킨다.
		this.pageInit(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통처리 메서드로 제어를 이동시킨다.
		this.pageInit(request,response);
	}
	
	/**
	 * Get, post 방식에 상관없이 공통 처리되는 메서드
	 * @param request - JSP request 내장객체
	 * @param response - JSP response 내장객체
	 * */
	private void pageInit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// 페이지 형식 지정하기
		response.setContentType("text/html; charset=utf-8");
		//파라미터 처리형식 지정하기
		request.setCharacterEncoding("utf-8");
		
		//현재URL을 획득해서 로그에 출력한다
		String url = request.getRequestURL().toString();
		if(request.getQueryString() != null) {
			url = url + "?" + request.getQueryString();
		}
		// GET방식인지 POST방식인지 조회한다
		String methodName = request.getMethod();
		
		logger.info("[" + methodName + "]" + url);
		
		// view의 이름
		String view = doRun(request, response);
		
		//획득한 view 가 존재한다면 화면표시
		if(view != null) {
			//view를 생성한다
			view = "/WEB-INF/views/" + view + ".jsp";
			logger.info("[View]" + view);
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
	}
	
	/** 웹 페이지 구성에 필요한 처리를 수행한후, view 의 이름을 리턴한다*/
	public abstract String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
	

}
