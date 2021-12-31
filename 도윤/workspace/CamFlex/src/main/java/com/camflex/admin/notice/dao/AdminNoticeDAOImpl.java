package com.camflex.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.notice.vo.NoticeVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminNoticeDAOImpl implements AdminNoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.admin.notice.dao.AdminNoticeDAO";
	
	@Override
	public List<NoticeVO> noticeList(PageRequest pageRequest) {

		return sqlSession.selectList(namespace + ".noticeList");
	}

	@Override
	public int regNotice(NoticeVO nvo) {
		
		return sqlSession.insert(namespace + ".regNotice", nvo);
	}

	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		
		return (NoticeVO)sqlSession.selectOne(namespace + ".noticeDetail", nvo);
	}

	@Override
	public int updateNotice(NoticeVO nvo) {
		
		return sqlSession.update(namespace + ".updateNotice", nvo);
	}

	
	@Override
	public int count(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count");
	}
}
