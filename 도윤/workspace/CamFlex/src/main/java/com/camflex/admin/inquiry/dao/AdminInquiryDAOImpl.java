package com.camflex.admin.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.inquiry.vo.InquiryVO;

@Repository
public class AdminInquiryDAOImpl implements AdminInquiryDAO {

	@Autowired
	private SqlSession sqlSession;

	// 리스트 조회
	@Override
	public List<InquiryVO> inquiryList(InquiryVO ivo) {
		
		return sqlSession.selectList("inquiryList");
	}

	// 상세 페이지
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		
		return sqlSession.selectOne("inquiryDetail", ivo);
	}
}
