package com.camflex.client.notice.controller;

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
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private Logger log = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	// 공지사항 조회
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public void noticeList(@ModelAttribute("pgrq") PageRequest pageRequest, AdminNoticeVO nvo, Model model) throws Exception {
		log.info("noticeList 호출 성공");
		
		/*
		 * List<AdminNoticeVO> noticeList = noticeService.noticeList(nvo);
		 * 
		 * model.addAttribute("noticeList", noticeList); model.addAttribute("data",
		 * nvo);
		 * 
		 * return "notice/noticeList";
		 */
		// 뷰에 페이징 처리를 한 게시글 목록을 전달한다.
		model.addAttribute("noticeList", noticeService.noticeList(pageRequest));
		
		// 페이징 네비게시션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(noticeService.count(pageRequest));
		model.addAttribute("pagination", pagination);
	}
	
	// 공지사항 상세 페이지
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute AdminNoticeVO nvo, Model model) throws Exception {
		log.info("noticeDetail 호출 성공");
		log.info("n_number = " + nvo.getN_number());
		
		AdminNoticeVO detail = new AdminNoticeVO();
		detail = noticeService.noticeDetail(nvo);
		
		if(detail != null && (!detail.equals(""))) {
			detail.setN_content(detail.getN_content().toString().replace("/n", "<br>"));
		}
		
		model.addAttribute("detail", detail);
		
		return "notice/noticeDetail";
	}
}
