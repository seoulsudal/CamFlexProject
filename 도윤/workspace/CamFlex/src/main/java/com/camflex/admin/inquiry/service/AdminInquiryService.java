package com.camflex.admin.inquiry.service;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

public interface AdminInquiryService {

	// 리스트 조회
	public List<InquiryVO> inquiryList(PageRequest pageRequest);
	// 상세 페이지
	public InquiryVO inquiryDetail(InquiryVO ivo);
	// 답글 구현
	public int replyInquiry(InquiryVO ivo);
	// 문의사항 답글 수정 처리
	public int update(InquiryVO ivo);
	// 전체 문의글 수를 반환
	public int inquiryCount(PageRequest pageRequest);

}
