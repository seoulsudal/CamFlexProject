package com.camflex.admin.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminInquiryDAOImpl implements AdminInquiryDAO {

	@Autowired
	private SqlSession sqlSession;

	// 리스트 조회
	@Override
	public List<InquiryVO> inquiryList(PageRequest pageRequest) {
		
		return sqlSession.selectList("inquiryList");
	}

	// 상세 페이지
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		
		return sqlSession.selectOne("inquiryDetail", ivo);
	}
	
	// 답글 등록
	@Override
	public int replyInquiry(InquiryVO ivo) {
		
		return sqlSession.insert("replyInquiry", ivo);
	}

	// 답글 수정
	@Override
	public int update(InquiryVO ivo) {
		
		return sqlSession.update("update", ivo);
	}

	// 문의 글 전체 수
	@Override
	public int inquiryCount(PageRequest pageRequest) {
		
		return sqlSession.selectOne("inquiryCount");
	}
}
