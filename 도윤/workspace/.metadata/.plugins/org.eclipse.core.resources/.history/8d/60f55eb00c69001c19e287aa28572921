package com.camflex.admin.inquiry.controller;

import java.util.List;

import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.inquiry.service.AdminInquiryService;
import com.camflex.client.inquiry.vo.InquiryVO;

@Controller
@RequestMapping("/admin/inquiry")
public class AdminInquiryController {

	@Autowired
	private AdminInquiryService adminInquiryService;
	
	/*****************************
	 * 문의사항 리스트
	 ****************************/
	@RequestMapping(value = "/inquiryList", method = RequestMethod.GET)
	public String inquiryList(@ModelAttribute InquiryVO ivo, Model model) {
		Log.info("문의사항 게시판 리스트 호출 성공");
		
		List<InquiryVO> inquiryList = adminInquiryService.inquiryList(ivo);
		
		model.addAttribute("inquiryList", inquiryList);
		
		return "admin/inquiry/inquiryList";
	}
	
	/***************************
	 * 문의사항 상세 페이지
	 ***************************/
	@RequestMapping(value = "/inquiryDetail", method = RequestMethod.GET)
	public String inquiryDetail(@ModelAttribute InquiryVO ivo, Model model) {
		Log.info("문의사항 상세 페이지 호출 성공");
		Log.info("글 번호 : " + ivo.getI_number());
		
		InquiryVO detail = new InquiryVO();
		
		detail = adminInquiryService.inquiryDetail(ivo);
		
		model.addAttribute("detail", detail);
		
		return "admin/inquiry/inquiryDetail";
	}
}
