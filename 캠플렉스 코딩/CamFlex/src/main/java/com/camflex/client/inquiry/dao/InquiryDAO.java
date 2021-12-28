package com.camflex.client.inquiry.dao;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;

public interface InquiryDAO {

	// 문의 목록 구현
	public List<InquiryVO> inquiryList() throws Exception;
	
}
