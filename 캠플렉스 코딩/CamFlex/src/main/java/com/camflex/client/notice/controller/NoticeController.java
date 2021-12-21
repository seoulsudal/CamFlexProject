package com.camflex.client.notice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.client.notice.service.NoticeService;
import com.camflex.client.reservation.controller.ReservationController;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private Logger log = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 조회
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute AdminNoticeVO nvo, Model model) throws Exception {
		log.info("noticeList 호출 성공");
		
		List<AdminNoticeVO> noticeList = noticeService.noticeList(nvo);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("data", nvo);
		
		return "notice/noticeList";
	}
}
