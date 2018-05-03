package study.jsp.mysite.controller.member;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import study.jsp.helper.BaseController;
import study.jsp.helper.FileInfo;
import study.jsp.helper.RegexHelper;
import study.jsp.helper.UploadHelper;
import study.jsp.helper.WebHelper;
import study.jsp.mysite.dao.MyBatisConnectionFactory;
import study.jsp.mysite.model.Member;
import study.jsp.mysite.service.MemberService;
import study.jsp.mysite.service.impl.MemberServiceImpl;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/member/join_ok.do")
public class JoinOk extends BaseController {

	private static final long serialVersionUID = -119449740030506798L;

	/** (1) 사용하고자 하는 Helper + Service 객체 선언*/
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	UploadHelper upload;
	MemberService memberService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MyBatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		upload = UploadHelper.getInstance();
		//회원가입처리를 위한 Service 객체
		memberService = new MemberServiceImpl(sqlSession, logger);
		
		/** (3) 로그인 여부 검사*/
		// 로그인 중이라면 이페이지를 동작시켜서는 안된다
		if(web.getSession("loginInfo") != null) {
			web.redirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다");
			return null;
		}
		
		/** (4) 파일이 포함된 POST 파라미터 받기 */
		try {
			upload.multipartRequest(request);
		} catch(Exception e) {
			sqlSession.close();
			web.redirect(null, "multipart 데이터가 아닙니다");
			return null;
		}
		
		// UploadHelper에서 텍스트 형식의 파라미터를 분류한 Map을 리턴받아서 값을 추출한다
		Map<String, String> paramMap = upload.getParamMap();
		String userId = paramMap.get("user_id");
		String userPw = paramMap.get("user_pw");
		String userPwRe = paramMap.get("user_pw_re");
		String name = paramMap.get("name");
		String email = paramMap.get("email");
		String tel = paramMap.get("tel");
		String birthdate = paramMap.get("birthdate");
		String gender = paramMap.get("gender");
		String postcode = paramMap.get("postcode");
		String addr1 = paramMap.get("addr1");
		String addr2 = paramMap.get("addr2");
		
		//전달받은 파라미터는 값의 정상여부 확인을 위해서 로그로 확인
		logger.debug("userId=" + userId);
		logger.debug("userPw=" + userPw);
		logger.debug("userPwRe=" + userPwRe);
		logger.debug("name=" + name);
		logger.debug("email=" + email);
		logger.debug("tel=" + tel);
		logger.debug("birthdate=" + birthdate);
		logger.debug("gender=" + gender);
		logger.debug("postcode=" + postcode);
		logger.debug("addr1=" + addr1);
		logger.debug("addr2=" + addr2);
		
		/** (5) 입력값의 유효성 검사 */
		//아이디 검사
		if(!regex.isValue(userId)) {
			sqlSession.close();
			web.redirect(null, "아이디를 입력하세요");
			return null;
		}
		if(!regex.isEngNum(userId)) {
			sqlSession.close();
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자 까지만 가능합니다");
			return null;
		}
		if(userId.length() > 20) {
			sqlSession.close();
			web.redirect(null, "아이디는 숫자와 영문의 조합으로 20자 까지만 가능합니다");
			return null;
		}
		
		//비밀번호 검사
		if(!regex.isValue(userPw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호를 입력하세요");
			return null;
		}
		if(!regex.isEngNum(userPw)) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자 까지만 가능합니다");
			return null;
		}
		if(userPw.length() > 20) {
			sqlSession.close();
			web.redirect(null, "비밀번호는 숫자와 영문의 조합으로 20자 까지만 가능합니다");
			return null;
		}
		
		//비밀번호확인
		if(!userPw.equals(userPwRe)) {
			sqlSession.close();
			web.redirect(null, "비밀번호확인이 잘못되었습니다");
			return null;
		}
		
		//이름 검사
		if(!regex.isValue(name)) {
			sqlSession.close();
			web.redirect(null, "이름을 입력하세요");
			return null;
		}
		if(!regex.isKor(name)) {
			sqlSession.close();
			web.redirect(null, "이름은 한글만 입력가능합니다");
			return null;
		}
		if(name.length() < 2 || name.length() > 5) {
			sqlSession.close();
			web.redirect(null, "이름은 2~5글자 까지만 가능합니다");
			return null;
		}
		
		//이메일 검사
		if(!regex.isValue(email)) {
			sqlSession.close();
			web.redirect(null, "이메일을 입력하세요");
			return null;
		}
		if(!regex.isEmail(email)) {
			sqlSession.close();
			web.redirect(null, "이메일의 형식이 잘못되었습니다");
			return null;
		}
		
		//연락처 검사
		if(!regex.isValue(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처를 입력하세요");
			return null;
		}
		if(!regex.isCellPhone(tel) && !regex.isTel(tel)) {
			sqlSession.close();
			web.redirect(null, "연락처의 형식이 잘못되었습니다");
			return null;
		}
		
		//생년월일 검사
		if(!regex.isValue(birthdate)) {
			sqlSession.close();
			web.redirect(null, "생년월일을 입력하세요");
			return null;
		}
		
		//성별 검사
		if(!regex.isValue(gender)) {
			sqlSession.close();
			web.redirect(null, "성별을 입력하세요");
			return null;
		}
		if(!gender.equals("M") && !gender.equals("F")) {
			sqlSession.close();
			web.redirect(null, "성별이 잘못되었습니다");
			return null;
		}
		
		
		
		/** (6) 업로드 된 파일 정보 추출 */
		List<FileInfo> fileList = upload.getFileList();
		//업로드된 프로필 사진 경로가 저장될 변수
		String profileImg = null;
		
		//업로드된 파일이 존재할 경우만 변수값을 할당한다
		if(fileList.size() > 0) {
			//단일 업로드이므로 0버내 항목만 가져온다
			FileInfo info = fileList.get(0);
			profileImg = info.getFileDir() + "/" + info.getFileName();
			
		}
		//파일 경로를 로그로 기록
		logger.debug("profileImg=" + profileImg);
		
		/** (7) 전달받은 파라미터를 Beans 객체에 담는다 */
		Member member = new Member();
		member.setUserId(userId);
		member.setUserPw(userPwRe);
		member.setName(name);
		member.setEmail(email);
		member.setTel(tel);
		member.setBirthdate(birthdate);
		member.setGender(gender);
		member.setPostcode(postcode);
		member.setAddr1(addr1);
		member.setAddr2(addr2);
		member.setProfileImg(profileImg);
		
		/** (8) Service 를 통한 데이터베이스 저장 처리 */
		try {
			memberService.insertMember(member);
		} catch(Exception e) {
			sqlSession.close();
			web.redirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (9) 가입이 완료되었으므로 메인페이지로 이동 */
		sqlSession.close();
		web.redirect(web.getRootPath() + "/index.do", "회원가입이 완료되었습니다. 로그인을 해 주세요");
		
		/*Insert, update, delete 처리를 수행하는 action페이지들은 자체적으로
		 * view를 갖지 않고 결과를 확인할 수 있는 다른페이지로 강제 이동시켜야 한다.
		 * (중복실행 방지) 그러므로 View의 경로를 리턴하지 않는다*/ 
		return null;
	}
	

}
