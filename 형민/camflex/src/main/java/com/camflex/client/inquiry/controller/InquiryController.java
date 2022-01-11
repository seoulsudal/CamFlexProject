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
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

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
	public String inquiryList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("pgrq")PageRequest pageRequest, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다."); 

		log.info("inquiryList 호출 성공");
		log.info("접속 ID = " + m_id);
		
		pageRequest.setM_id(m_id);
		
		model.addAttribute("inquiryList", inquiryService.inquiryList(pageRequest));
		
		// 페이징 기법
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(inquiryService.count(pageRequest));
		model.addAttribute("pagination", pagination);	
		model.addAttribute("id", m_id); 

		return "inquiry/inquiryList";
	}

	// 문의 글쓰기 구현
	@RequestMapping(value = "/inquiryWrite", method = RequestMethod.GET)
	public String inquiryWriteForm(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다."); 

		log.info("inquiryWriteForm 호출 성공");
		log.info("접속 ID = " + m_id);

		model.addAttribute("id", m_id);

		return "inquiry/inquiryWrite";
	}

	// 문의 글쓰기 처리
	@RequestMapping(value = "/inquiryWrite", method = RequestMethod.POST)
	public String inquiryWrite(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다."); 

		log.info("inquiryWrite 호출 성공");
		log.info("접속 ID = " + m_id);

		int result = 0;
		String url = "";

		result = inquiryService.inquiryWrite(ivo);

		if (result == 1) {
			url = "/inquiry/inquiryList";
		} else {
			model.addAttribute("code", 1);
			url = "/inquiry/inquiryWrite";
		}

		return "redirect:" + url;
	}

	// 문의 상세보기 구현
	@RequestMapping(value = "/inquiryDetail", method = RequestMethod.GET)
	public String inquiryDetail(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다."); 
		log.info("접속 ID = " + m_id);

		log.info("inquiryDetails 호출 성공");

		InquiryVO detail = new InquiryVO();
		detail = inquiryService.inquiryDetail(ivo);

		if (detail != null && (!detail.equals(""))) {
			detail.setI_content(detail.getI_content().toString().replaceAll("\n", "<br>"));
		}

		model.addAttribute("id", m_id);
		model.addAttribute("detail", detail);

		return "inquiry/inquiryDetail";
	}

	/*
	 * // 문의 수정 구현
	 * 
	 * @RequestMapping(value = "/inquiryUpdate", method = RequestMethod.GET) public
	 * String inquiryUpdateForm(HttpServletRequest request, HttpServletResponse
	 * response, @ModelAttribute InquiryVO ivo, Model model) throws Exception {
	 * sessionCheck(request, response, "로그인 후 예약 가능합니다."); log.info("접속 ID = " +
	 * m_id);
	 * 
	 * log.info("inquiryUpdateForm 호출 성공"); log.info("i_number : " +
	 * ivo.getI_number());
	 * 
	 * InquiryVO updateData = new InquiryVO(); updateData =
	 * inquiryService.inquiryDetail(ivo);
	 * 
	 * 
	 * log.info("title " + updateData.getI_title()); log.info("kinds " +
	 * updateData.getI_kinds()); log.info("content " + updateData.getI_content());
	 * 
	 * 
	 * model.addAttribute("number", ivo.getI_number());
	 * model.addAttribute("updateData", updateData);
	 * 
	 * return "inquiry/inquiryUpdate"; }
	 * 
	 * // 문의 수정 처리
	 * 
	 * @RequestMapping(value = "/inquiryUpdate", method = RequestMethod.POST) public
	 * String inquiryUpdate(HttpServletRequest request, HttpServletResponse
	 * response, @ModelAttribute InquiryVO ivo) throws Exception {
	 * sessionCheck(request, response, "로그인 후 예약 가능합니다."); log.info("접속 ID = " +
	 * m_id);
	 * 
	 * log.info("inquiryUpdate 호출 성공");
	 * 
	 * int result = 0; String url = "";
	 * 
	 * result = inquiryService.inquiryUpdate(ivo);
	 * 
	 * if(result == 1) { url = "/inquiry/inquiryDetail?i_number=" +
	 * ivo.getI_number(); } else { url = "/inquiry/inquiryUpdate?i_number=" +
	 * ivo.getI_number(); }
	 * 
	 * return "redirect:" + url; }
	 * 
	 * // 문의 삭제 처리
	 * 
	 * @RequestMapping(value = "/inquiryDelete", method = RequestMethod.GET) public
	 * String inquiryDelete(HttpServletRequest request, HttpServletResponse
	 * response, @ModelAttribute InquiryVO ivo) throws Exception {
	 * sessionCheck(request, response, "로그인 후 예약 가능합니다."); log.info("접속 ID = " +
	 * m_id);
	 * 
	 * log.info("inquiryDelete 호출 성공");
	 * 
	 * int result = 0; String url = "";
	 * 
	 * result = inquiryService.inquiryDelete(ivo.getI_number());
	 * 
	 * if(result == 1) { url = "/inquiry/inquiryList"; } else { url =
	 * "/inquiry/inquiryDetail?i_number=" + ivo.getI_number(); }
	 * 
	 * return "redirect:" + url; }
	 */

	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message)
			throws Exception {
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
