package com.camflex.client.member.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.member.service.MemberService;
import com.camflex.client.notice.controller.NoticeController;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/member")
public class MemberController {

	private Logger log = LoggerFactory.getLogger(NoticeController.class);
	
	private HttpSession session;
	private String m_id;
	
	@Autowired
	private MemberService memberService;
	
	// 예약 취소 리스트 구현
	@RequestMapping(value = "/cancelList", method = RequestMethod.GET)
	private String cancelList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("pgrq")PageRequest pageRequest, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다."); 

		log.info("cancelList 호출 성공");
		log.info("접속 ID = " + m_id);
		
		pageRequest.setM_id(m_id);
		
		model.addAttribute("cancelList", memberService.cancelList(pageRequest));
		
		// 페이징 기법
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(memberService.count(pageRequest));
		model.addAttribute("pagination", pagination);	
		model.addAttribute("id", m_id); 
		
		return "member/cancelList";
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
	
		log.info("여긴 m_id " + m_id);
			if (m_id == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('" + message + "');");
			out.println("location.href='/login/login'");
			out.println("</script>");
			out.flush();
		}
	}
}
