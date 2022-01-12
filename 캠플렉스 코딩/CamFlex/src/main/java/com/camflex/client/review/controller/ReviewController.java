package com.camflex.client.review.controller;

import java.io.PrintWriter;

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

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.client.reservation.controller.ReservationController;
import com.camflex.client.review.service.ReviewService;
import com.camflex.client.review.vo.ReviewVO;
import com.camflex.common.vo.PageRequest;

@Controller
@RequestMapping("/review")
public class ReviewController {

	private Logger log = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewService reviewService;
	
	private HttpSession session;
	private String m_id;
	
	// 댓글 글쓰기 구현
	@RequestMapping(value = "/reviewInsert", method = RequestMethod.GET)
	public String reviewInsertForm(HttpServletRequest request, HttpServletResponse response, ReviewVO rvvo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("접속한 ID = " + m_id);
		
		log.info("reviewInsertForm 호출 성공");
		log.info("p_number = " + rvvo.getP_number());
		log.info("r_number = " + rvvo.getR_number());
		
		model.addAttribute("rv_count", reviewService.rv_count(rvvo.getR_number()));
		
		model.addAttribute("id", m_id);
		model.addAttribute("p_number", rvvo.getP_number());
		model.addAttribute("r_number", rvvo.getR_number());
		
		return "review/reviewInsert";
	}
	
	// 댓글 글쓰기 처리
	@RequestMapping(value = "/reviewInsert", method = RequestMethod.POST)
	public String reviewInsert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReviewVO rvvo, Model model) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("접속한 ID = " + m_id);
		
		log.info("reviewInsert 호출 성공");
		
		int result = 0;
		String url = "";
		
		result = reviewService.reviewInsert(rvvo);
		
		if(result == 1) {
			url = "/product/productDetail?p_number=" + rvvo.getP_number();
		} else {
			url = "/review/reviewInsert";
		}
		
		return "redirect:" + url;
	}
	
	// 로그인 체크(로그인)
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
