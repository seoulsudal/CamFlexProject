package com.camflex.admin.main.controller;

import java.io.PrintWriter;
import java.util.List;

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

import com.camflex.admin.main.service.AdminMainService;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;

@Controller
@RequestMapping("/admin")
public class AdminMainController {
	
	private Logger log = LoggerFactory.getLogger(AdminMainController.class);
	
	private HttpSession session;
	private String m_id;
	
	@Autowired
	private AdminMainService adminMainService;
	
	// 메인 페이지
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainList(@ModelAttribute MemberVO mvo, ReservationVO rvo, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		
		log.info("메인 페이지 호출 성공");
		
		model.addAttribute("id", m_id);
		
		// 오늘 날짜 기준 가입한 회원 수 출력
		List<MemberVO> todayMember = adminMainService.mainList(mvo);
		
		model.addAttribute("todayMember", todayMember);
		model.addAttribute("data", mvo);
		
		List<ReservationVO> newRsv = adminMainService.rsvList(rvo);
		model.addAttribute("newRsv", newRsv);
		
		List<ReservationVO> visit = adminMainService.visit(rvo);
		model.addAttribute("visit", visit);
		
		List<ReservationVO> yesterday = adminMainService.yesterday(rvo);
		model.addAttribute("yesterday", yesterday);
		
		return "admin/main";
	}
	
	/***********************
	 * 로그인 체크
	 ***********************/
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id : " + m_id);
		
		if(m_id == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('" + message + "');");
			out.println("location.href='/admin/login/login'");
			out.println("</script>");
			out.flush();
		}
	}
	
}
