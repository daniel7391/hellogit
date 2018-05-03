package study.jsp.mysite.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import study.jsp.mysite.model.BbsFile;
import study.jsp.mysite.service.BbsFileService;

public class BbsFileServiceImpl implements BbsFileService{

	/** 처리 결과를 기록할 Log4J 객체 생성*/
	Logger logger;
	
	/** MyBatis */
	SqlSession sqlSession;
	
	/** 생성자를 통한 객체 생성 */
	public BbsFileServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	@Override
	public void insertFile(BbsFile file) throws Exception {
		try {
			int result = sqlSession.insert("BbsFileMapper.insertFile", file);
			if(result == 0) {
				throw new NullPointerException();
			}
		} catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 파일정보가 없습니다");
		} catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 등록에 실패했습니다");
		} finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<BbsFile> selectFileList(BbsFile file) throws Exception {
		List<BbsFile> result = null;
		
		try {
			//첨부파일이 없는 경우도 있으므로 조회결과가 null인 경우 예외를 발생하지 않는다
			result = sqlSession.selectList("BbsFileMapper.selectFileList", file);
		} catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다");
		}
		
		return result;
	}

}
