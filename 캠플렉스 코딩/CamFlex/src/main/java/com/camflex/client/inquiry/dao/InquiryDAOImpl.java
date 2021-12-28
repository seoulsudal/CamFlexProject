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
	public List<InquiryVO> inquiryList() throws Exception {
		return sqlSession.selectList("inquiryList");
	}

	
}
