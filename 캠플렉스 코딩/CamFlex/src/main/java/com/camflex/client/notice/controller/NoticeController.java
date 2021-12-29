package com.camflex.client.notice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	private HttpSession session;
	private String m_id;
	
	// 공지사항 조회
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("pgrq") PageRequest pageRequest, AdminNoticeVO nvo, Model model) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("noticeList 호출 성공");
		
		// 뷰에 페이징 처리를 한 게시글 목록을 전달한다.
		model.addAttribute("noticeList", noticeService.noticeList(pageRequest));
		
		// 페이징 네비게시션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(noticeService.count(pageRequest));
		model.addAttribute("pagination", pagination);
		model.addAttribute("id", m_id);
		
		return "notice/noticeList";
	}
	
	// 공지사항 상세 페이지
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public String noticeDetail(HttpServletRequest request, HttpServletResponse response, @ModelAttribute AdminNoticeVO nvo, Model model) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("noticeDetail 호출 성공");
		log.info("n_number = " + nvo.getN_number());
		
		AdminNoticeVO detail = new AdminNoticeVO();
		detail = noticeService.noticeDetail(nvo);
		
		if(detail != null && (!detail.equals(""))) {
			detail.setN_content(detail.getN_content().toString().replace("/n", "<br>"));
		}
		
		model.addAttribute("detail", detail);
		model.addAttribute("id", m_id);
		
		return "notice/noticeDetail";
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("여긴 m_id " + m_id);
	}
	
}
