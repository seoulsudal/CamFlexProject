package com.camflex.admin.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.inquiry.dao.AdminInquiryDAO;
import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class AdminInquiryServiceImpl implements AdminInquiryService {

	@Autowired
	private AdminInquiryDAO adminInquiryDAO;

	// 리스트 조회
	@Override
	public List<InquiryVO> inquiryList(PageRequest pageRequest) {
		
		return adminInquiryDAO.inquiryList(pageRequest);
	}
	// 상세 페이지
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) {
		InquiryVO detail = null;
		
		detail = adminInquiryDAO.inquiryDetail(ivo);
		
		return detail;
	}
	
	// 답글 등록 구현
	@Override
	public int replyInquiry(InquiryVO ivo) {
		int result = 0;
		try {
			result = adminInquiryDAO.replyInquiry(ivo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
	// 문의글 답글 수정
	@Override
	public int update(InquiryVO ivo) {
		int result = 0;
		try {
			result = adminInquiryDAO.update(ivo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
	// 전체 문의글 수를 반환
	@Override
	public int inquiryCount(PageRequest pageRequest) {

		return  adminInquiryDAO.inquiryCount(pageRequest);
	}
}
