package study.jsp.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.jsp.helper.BaseController;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index.do")
public class Index extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2811471017433507545L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "index";
	}
	

}
