package com.camflex.admin.inquiry.dao;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

public interface AdminInquiryDAO {

	// 리스트 조회
	public List<InquiryVO> inquiryList(PageRequest pageRequest);
	// 상세 페이지
	public InquiryVO inquiryDetail(InquiryVO ivo);
	// 답글 등록
	public int replyInquiry(InquiryVO ivo);
	// 답글 수정 처리
	public int update(InquiryVO ivo);
	// 문의글 전체 수 반환
	public int inquiryCount(PageRequest pageRequest);
}
