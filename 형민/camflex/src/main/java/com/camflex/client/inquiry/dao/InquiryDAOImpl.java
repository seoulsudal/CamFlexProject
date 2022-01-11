package com.camflex.client.inquiry.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class InquiryDAOImpl implements InquiryDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.client.inquiry.dao.InquiryDAO";
	
	// 문의 목록 구현
	@Override
	public List<InquiryVO> inquiryList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList(namespace + "inquiryList");
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

	// 문의 삭제 처리
	@Override
	public int inquiryDelete(int i_number) throws Exception {
		return sqlSession.delete("inquiryDelete", i_number);
	}

	// 문의 전체 수
	@Override
	public int count(PageRequest pageRequest) throws Exception{
		return sqlSession.selectOne("count");
	}

	
}
