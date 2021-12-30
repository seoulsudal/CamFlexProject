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
	public List<InquiryVO> inquiryList(String m_id) throws Exception {
		List<InquiryVO> list = inquiryDAO.inquiryList(m_id);
		
		return list;
	}

	// 문의 글쓰기 처리
	@Override
	public int inquiryWrite(InquiryVO ivo) throws Exception {
		int result = 0;
		
		try {
			result = inquiryDAO.inquiryWrite(ivo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}

	// 문의 상세보기
	@Override
	public InquiryVO inquiryDetail(InquiryVO ivo) throws Exception {
		InquiryVO detail = null;
		detail = inquiryDAO.inquiryDetail(ivo);
			
		return detail;
	}

	// 문의 수정 처리
	@Override
	public int inquiryUpdate(InquiryVO ivo) throws Exception {
		int result = 0;
		
		try {
			result = inquiryDAO.inquiryUpdate(ivo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
}
