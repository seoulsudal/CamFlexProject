package com.camflex.client.inquiry.dao;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;

public interface InquiryDAO {

	// 문의 목록 구현
	public List<InquiryVO> inquiryList(String m_id) throws Exception;

	// 문의 글쓰기 처리
	public int inquiryWrite(InquiryVO ivo) throws Exception;

	// 문의 상세보기
	public InquiryVO inquiryDetails(InquiryVO ivo) throws Exception;

	// 문의 수정 처리
	public int inquiryUpdate(InquiryVO ivo) throws Exception;
	
}
