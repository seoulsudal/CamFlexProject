package com.camflex.client.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.inquiry.dao.InquiryDAO;
import com.camflex.client.inquiry.vo.InquiryVO;

@Service
@Transactional
public class InquiryServiceImpl implements InquiryService {
	
	@Autowired
	private InquiryDAO inquiryDAO;

	// 문의 목록 구현
	@Override
	public List<InquiryVO> inquiryList() throws Exception {
		List<InquiryVO> list = inquiryDAO.inquiryList();
		
		return list;
	}
	
}
