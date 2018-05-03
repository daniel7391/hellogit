package study.jsp.mysite.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.jsp.helper.BaseController;
import study.jsp.helper.UploadHelper;
import study.jsp.helper.WebHelper;
import study.jsp.mysite.dao.MyBatisConnectionFactory;
import study.jsp.mysite.model.Member;
import study.jsp.mysite.service.MemberService;
import study.jsp.mysite.service.impl.MemberServiceImpl;

/**
 * Servlet implementation class LoginOk
 */
@WebServlet("/member/login_ok.do")
public class LoginOk extends BaseController {
	
	private static final long serialVersionUID = -4124214171500366910L;

	/** (1) 사용하고자 하는 Helper + Service 객체 선언*/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UploadHelper upload;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		upload = UploadHelper.getInstance();
		//회원가입처리를 위한 Service 객체
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		/** (3) 로그인 여부 검사*/
		// 로그인 중이라면 이페이지를 동작시켜서는 안된다
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다");
			return null;
		}
		
		/** (4)  파라미터 처리 */
		String userId = web.getString("user_id");
		String userPw = web.getString("user_pw");
		
		logger.debug("userId=" + userId);
		logger.debug("userPw=" + userPw);
		
		if(userId == null || userPw == null) {
			sqlSession.close();
			web.redirect(null, "아이디나 비밀번호가 없습니다");
			return null;
		}
		
		/** (5) 입력값의 유효성 검사 */
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPw(userPw);
		
		/** (6) Service를 통한 회원인증 */
		Member loginInfo = null;
		
		try {
			loginInfo = memberService.selectLoginInfo(member);
			
		} catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (7) 프로필 이미지 처리*/
		//프로필 이미지가 있을 경우 썸네일을 생성하여 쿠키에 별도로 저장
		String profileImg = loginInfo.getProfileImg();
		if (profileImg != null) {
			try {
				String profileThumbnail =  upload.createThumbnail(profileImg, 40, 40, true);
				web.setCookie("profileThumbnail", profileThumbnail, -1);
			} catch (Exception e) {
				web.redirect(null, e.getLocalizedMessage());
				return null;
			}
		}
		
		/** (8) 조회된 회원 정보를 세션에 저장*/
		/*로그인 처리는 아이디와 비밀번호를 기반으로 조회된 정보를 세션에 
		 * 보관하는 과정을 말한다. 로그인에 대한 판별은 저장된 세션정보의 존재여부로 판별한다*/
		web.setSession("loginInfo", loginInfo);
		
		
		/** (9) 페이지 이동*/
		//이전페이지 구하기(Javascript로 이동된 경우 조회 안됨)
		String movePage = request.getHeader("referer");
		if(movePage == null) {
			movePage = web.getRootPath() + "/index.do";
			
		}
		
		sqlSession.close();
		web.redirect(movePage, null);
		return null;
	}
	

}
