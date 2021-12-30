package com.camflex.client.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.inquiry.vo.InquiryVO;

@Repository
public class InquiryDAOImpl implements InquiryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.client.inquiry.dao.InquiryDAO";
	
	// 문의 목록 구현
	@Override
	public List<InquiryVO> inquiryList(String m_id) throws Exception {
		return sqlSession.selectList(namespace + "inquiryList", m_id);
	}

	// 문의 글쓰기 처리
	@Override
	public int inquiryWrite(InquiryVO ivo) throws Exception {
		return sqlSession.insert(namespace + "inquiryWrite", ivo);
	}

	// 문의 상세보기
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) throws Exception {
		return sqlSession.selectOne("inquiryDetail", ivo);
	}

	// 문의 수정 처리
	@Override
	public int inquiryUpdate(InquiryVO ivo) throws Exception {
		return sqlSession.update(namespace + "inquiryUpdate", ivo);
	}

	
}
