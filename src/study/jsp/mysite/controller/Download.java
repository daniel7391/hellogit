package study.jsp.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.jsp.helper.BaseController;
import study.jsp.helper.UploadHelper;
import study.jsp.helper.WebHelper;


/**
 * Servlet implementation class Download
 */
@WebServlet("/download.do")
public class Download extends BaseController {
	private static final long serialVersionUID = 788977139083197914L;
	
	/**(1) 사용하고자 하는 Helepr + Service 객체 선언*/
	Logger logger;
	WebHelper web;
	UploadHelper upload;
	
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**(2) 사용하고자 하는  Helepr + Service 객체 선언*/
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		
		/**(3) 파라미터 받기*/
		String filePath = web.getString("file");
		String orginName = web.getString("orfin");
		
		/**(4) 다운로드 스트림 출력하기 */
		if(filePath != null) {
			try {
				logger.debug("Create Thumbnail Image -->" + filePath);
				upload.printFileStream(response, filePath, orginName);
			} catch(IOException e) {
				logger.debug(e.getLocalizedMessage());
			}
		}
		
		return null;
	}
	
}
