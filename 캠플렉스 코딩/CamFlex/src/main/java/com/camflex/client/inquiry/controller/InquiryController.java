package com.camflex.client.inquiry.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.inquiry.service.InquiryService;
import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.client.reservation.controller.ReservationController;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	private Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private InquiryService inquiryService;
	
	// 문의 목록 구현
	@RequestMapping(value = "/inquiryList", method = RequestMethod.GET)
	public String inquiryList(Model model) throws Exception {
		log.info("inquiryList 호출 성공");
		
		List<InquiryVO> inquiryList = inquiryService.inquiryList();
		
		model.addAttribute("inquiryList", inquiryList);
		model.addAttribute("data");
		
		return "inquiry/inquiryList";
	}
}
