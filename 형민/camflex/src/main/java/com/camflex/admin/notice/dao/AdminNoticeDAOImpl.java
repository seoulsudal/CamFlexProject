package com.camflex.admin.notice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminNoticeDAOImpl implements AdminNoticeDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.admin.notice.dao.AdminNoticeDAO";
	
	@Override
	public List<AdminNoticeVO> noticeList(PageRequest pageRequest) {

		return sqlSession.selectList(namespace + ".noticeList");
	}

	@Override
	public int regNotice(AdminNoticeVO nvo) {
		
		return sqlSession.insert(namespace + ".regNotice", nvo);
	}

	@Override
	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) {
		
		return (AdminNoticeVO)sqlSession.selectOne(namespace + ".noticeDetail", nvo);
	}

	@Override
	public int updateNotice(AdminNoticeVO nvo) {
		
		return sqlSession.update(namespace + ".updateNotice", nvo);
	}

	
	@Override
	public int count(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count");
	}
}
