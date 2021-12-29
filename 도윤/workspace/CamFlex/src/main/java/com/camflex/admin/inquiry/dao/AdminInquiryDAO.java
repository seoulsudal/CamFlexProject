package com.camflex.admin.inquiry.dao;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;

public interface AdminInquiryDAO {

	// 리스트 조회
	public List<InquiryVO> inquiryList(InquiryVO ivo);
	// 상세 페이지
	public InquiryVO inquiryDetail(InquiryVO ivo);

}
