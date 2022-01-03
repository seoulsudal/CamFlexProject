package com.camflex.admin.inquiry.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.inquiry.service.AdminInquiryService;

import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

@Controller
@RequestMapping("/admin/inquiry")
public class AdminInquiryController {
	private Logger log = LoggerFactory.getLogger(AdminInquiryController.class);
	@Autowired
	private AdminInquiryService adminInquiryService;
	
	/*****************************
	 * 문의사항 리스트
	 ****************************/
	@RequestMapping(value = "/inquiryList", method = RequestMethod.GET)
	public void inquiryList(@ModelAttribute PageRequest pageRequest, Model model) {
		log.info("문의사항 게시판 리스트 호출 성공");
		
		// List<InquiryVO> inquiryList = adminInquiryService.inquiryList(ivo);
		
		model.addAttribute("inquiryList", adminInquiryService.inquiryList(pageRequest));
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminInquiryService.inquiryCount(pageRequest));
		model.addAttribute("pagination", pagination);
	}
	
	/***************************
	 * 문의사항 상세 페이지
	 ***************************/
	@RequestMapping(value = "/inquiryDetail", method = RequestMethod.GET)
	public String inquiryDetail(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("문의사항 상세 페이지 호출 성공");
		log.info("글 번호 : " + ivo.getI_number());
		
		InquiryVO detail = new InquiryVO();
		
		detail = adminInquiryService.inquiryDetail(ivo);
		
		model.addAttribute("detail", detail);
		
		return "admin/inquiry/inquiryDetail";
	}
	
	/****************************
	 * 문의사항 답글 폼
	 ****************************/
	@RequestMapping(value = "/replyInquiry", method = RequestMethod.GET)
	public String replyInquiry(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("문의사항 답글 폼 호출 성공");
		InquiryVO reply = new InquiryVO();
		
		reply = adminInquiryService.inquiryDetail(ivo);
		
		model.addAttribute("reply", reply);
		
		return "admin/inquiry/replyInquiry";
	}
	
	/***************************
	 * 문의사항 답글 구현
	 ***************************/
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("답글 구현");
		
		int result = 0;
		String url = "";
		
		result = adminInquiryService.replyInquiry(ivo);
		if(result == 1) {
			url = "/admin/inquiry/inquiryList";
		}else {
			url = "/admin/inquiry/replyInquiry";
		}
		return "redirect:" + url;
	}
	
	/****************************
	 * 문의사항 답글 수정 폼
	 ****************************/
	@RequestMapping(value = "/updateReplyInquiry", method = RequestMethod.GET)
	public String updateReplyInquiry(@ModelAttribute InquiryVO ivo, Model model) {
		log.info("문의사항 답글 폼 호출 성공");
		InquiryVO reply = new InquiryVO();
		
		reply = adminInquiryService.inquiryDetail(ivo);
		
		model.addAttribute("reply", reply);
		
		return "admin/inquiry/updateReplyInquiry";
	}
	
	/****************************
	 * 문의사항 답글 수정 구현
	 ***************************/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute InquiryVO ivo) {
	
		log.info("문의사항 답글 수정 구현");
		
		int result = 0;
		String url = "";
		
		result = adminInquiryService.update(ivo);
		if(result == 1) {
			url = "/admin/inquiry/inquiryList";
		}else {
			url = "/admin/inquiry/updateReplyInquiry";
		}
		return "redirect:" + url;
		
	}
}
