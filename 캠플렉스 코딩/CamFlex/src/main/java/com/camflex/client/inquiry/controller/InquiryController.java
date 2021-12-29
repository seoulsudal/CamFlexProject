package com.camflex.client.inquiry.controller;

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

import com.camflex.client.inquiry.service.InquiryService;
import com.camflex.client.inquiry.vo.InquiryVO;
import com.camflex.client.reservation.controller.ReservationController;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	private Logger log = LoggerFactory.getLogger(ReservationController.class);
	
	private HttpSession session;
	private String m_id;
	
	@Autowired
	private InquiryService inquiryService;
	
	// 문의 목록 구현
	@RequestMapping(value = "/inquiryList", method = RequestMethod.GET)
	public String inquiryList(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		
		log.info("inquiryList 호출 성공");
		log.info("접속 ID = " + m_id);
		
		List<InquiryVO> inquiryList = inquiryService.inquiryList(m_id);
		
		model.addAttribute("id", m_id);
		model.addAttribute("inquiryList", inquiryList);
		model.addAttribute("data");
		
		return "inquiry/inquiryList";
	}
	
	// 문의 글쓰기 구현
	@RequestMapping(value = "/inquiryWrite", method = RequestMethod.GET)
	public String inquiryWriteForm(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		
		log.info("inquiryWriteForm 호출 성공");
		log.info("접속 ID = " + m_id);
		
		model.addAttribute("id", m_id);
		
		return "inquiry/inquiryWrite";
	}
	
	// 문의 글쓰기 처리
	@RequestMapping(value = "/inquiryWrite", method = RequestMethod.POST)
	public String inquiryWrite(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		
		log.info("inquiryWrite 호출 성공");
		log.info("접속 ID = " + m_id);
		
		int result = 0;
		String url = "";
		
		result = inquiryService.inquiryWrite(ivo);
		
		if(result == 1) {
			url = "/inquiry/inquiryList";
		} else {
			model.addAttribute("code", 1);
			url = "/inquiry/inquiryWrite";
		}
		
		return "redirect:" + url;
	}
	
	// 문의 상세보기 구현
	@RequestMapping(value = "/inquiryDetails", method = RequestMethod.GET)
	public String inquiryDetails(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		log.info("접속 ID = " + m_id);
		
		log.info("inquiryDetails 호출 성공");
				
		InquiryVO detail = new InquiryVO();
		detail = inquiryService.inquiryDetails(ivo);
		
		if(detail != null) {
			detail.setI_content(detail.getI_content().toString().replaceAll("\n", "<br>"));
		}
		
		model.addAttribute("detail", detail);
		
		return "inquiry/inquiryDetails";
	}
	
	// 문의 수정 구현
	@RequestMapping(value = "/inquiryUpdate", method = RequestMethod.GET)
	public String inquiryUpdateForm(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		log.info("접속 ID = " + m_id);
		
		log.info("inquiryUpdateForm 호출 성공");
		
		InquiryVO updateData = new InquiryVO();
		updateData = inquiryService.inquiryDetails(ivo);
		
		model.addAttribute("updateData", updateData);
		
		return "inquiry/inquiryUpdate";
	}
	
	// 문의 수정 처리
	@RequestMapping(value = "/inquiryUpdate", method = RequestMethod.POST)
	public String inquiryUpdate(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo) throws Exception {
		sessionCheck(request, response, "로그인 후 예약 가능합니다.");
		log.info("접속 ID = " + m_id);
		
		log.info("inquiryUpdate 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = inquiryService.inquiryUpdate(ivo);
		
		if(result == 1) {
			url = "/inquiry/inquiryDetails?i_number=" + ivo.getI_number();
		} else {
			url = "/inquiry/inquiryUpdate?i_number=" + ivo.getI_number();
		}
		
		return "redirect:" + url;
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("여긴 m_id " + m_id);
		
		if(m_id == null) {
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
