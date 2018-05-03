package study.jsp.mysite.service;

import java.util.List;

import study.jsp.mysite.model.BbsFile;

public interface BbsFileService {
	/**
	 * 파일정보를 저장한다
	 * @param file- 파일데이터
	 * @throws Exception
	 * */
	public void insertFile(BbsFile file) throws Exception;
	
	/**
	 * 하나의 게시물에 종속된 파일 목록을 조회한다
	 * @param file- 게시물 일련번호를 저장하고있는 JavaBeans
	 * @return 파일 데이터 컬렉션
	 * @throws Exception
	 * */
	public List<BbsFile> selectFileList(BbsFile file) throws Exception;
}
