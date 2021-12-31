package com.camflex.client.inquiry.service;

import java.util.List;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;

public interface InquiryService {

	// 문의 목록 구현
	public List<InquiryVO> inquiryList(PageRequest pageRequest) throws Exception;

	// 문의 글쓰기 처리
	public int inquiryWrite(InquiryVO ivo) throws Exception;

	// 문의 상세보기
	public InquiryVO inquiryDetail(InquiryVO ivo) throws Exception;

	// 문의 수정 처리
	public int inquiryUpdate(InquiryVO ivo) throws Exception;

	// 문의 삭제 처리
	public int inquiryDelete(int i_number) throws Exception;

	// 카운트
	public int count(PageRequest pageRequest) throws Exception;

}
