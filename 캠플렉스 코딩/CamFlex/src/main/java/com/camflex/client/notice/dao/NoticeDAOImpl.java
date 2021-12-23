package com.camflex.client.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.client.notice.dao.NoticeDAO";

	// 공지사항 조회
	/*
	 * @Override public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws
	 * Exception { return sqlSession.selectList(namespace + ".noticeList", nvo); }
	 */

	// 상세 페이지
	@Override
	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) throws Exception {
		return sqlSession.selectOne("noticeDetail", nvo);
	}

	@Override
	public List<AdminNoticeVO> noticeList(PageRequest pageRequest) {
		return sqlSession.selectList(namespace + ".noticeList");
	}

	@Override
	public int count(PageRequest pageRequest) {
		return sqlSession.selectOne("count");
	}
	
}
