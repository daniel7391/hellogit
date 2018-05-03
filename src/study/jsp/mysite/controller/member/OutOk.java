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
 * Servlet implementation class OutOk
 */
@WebServlet("/member/out_ok.do")
public class OutOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376559507792705154L;
	
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
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		/** (3) 로그인 여부 검사*/
		// 로그인 중이 아니라면 탈퇴 할 수 없다
		if(web.getSession("loginInfo") == null) {
			web.redirect(web.getRootPath() + "/index.do", "로그인 후에 이용 가능합니다");
			return null;
		}
		
		/** (4) 파라미터 받기*/
		String userPw = web.getString("user_pw");
		logger.debug("userPw=" + userPw);
		
		if(userPw == null) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력하세요");
			return null;
		}
		
		
		/** (5) 서비스에 전달하기 위하여 파라미터를 Beans로 묶는다*/
		Member loginInfo = (Member) web.getSession("loginInfo");
		Member member = new Member();
		member.setId(loginInfo.getId());
		member.setUserPw(userPw);
		
		/** (6) Service를 통한 탈퇴 시도*/
		try {
			//비밀번호 검사 --> 비밀번호가 잘못된 경우 예외 발생
			memberService.selectMemberPasswordCount(member);
			//탈퇴 처리 
			memberService.deleteMember(member);
		} catch(Exception e) {
			web.redirect(null, e.getLocalizedMessage());
			return null;
		} finally {
			sqlSession.close();
		}
		
		// 탈퇴되었다면 프로필 이미지를 삭제한다
		upload.removeFile(loginInfo.getProfileImg());
		
		/** (7) 정상적으로 탈퇴된 경우 강제 로그아웃 및 페이지 이동*/
		web.removeAllSession();
		web.redirect(web.getRootPath() + "/index.do", "탈퇴되었습니다");
		
		return null;
	}
	

}
