package com.camflex.client.product.controller;

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

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.client.product.service.ProductService;
import com.camflex.client.reservation.controller.ReservationController;
import com.camflex.client.review.vo.ReviewVO;
import com.camflex.client.review.service.ReviewService;
import com.camflex.common.vo.PageRequest;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private Logger log = LoggerFactory.getLogger(ProductController.class);
	
	private HttpSession session;
	private String m_id;
	
	@Autowired 
	private ProductService productService;
	@Autowired
	private ReviewService reviewService;
	 
	// 캠핑장 조회
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public String productList(HttpServletRequest request, HttpServletResponse response, @ModelAttribute AdminProductVO pvo, Model model) throws Exception{
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("productList 호출 성공");
		
		List<AdminProductVO> productList = productService.productList(pvo);
		
		model.addAttribute("productList", productList);
		model.addAttribute("data", pvo);
		model.addAttribute("id", m_id);
				
		return "product/productList";
	}
	
	// 캠핑장 상세 페이지
	@RequestMapping(value = "/productDetail", method = RequestMethod.GET)
	public String productDetail(HttpServletRequest request, HttpServletResponse response, @ModelAttribute AdminProductVO pvo, ReviewVO rvvo, Model model) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("productDetail 호출 성공");
		log.info("p_number = " + pvo.getP_number());
		
		AdminProductVO detail = new AdminProductVO();
		detail = productService.productDetail(pvo);
		
		if(detail != null && (!detail.equals(""))) {
			detail.setP_information(detail.getP_information().toString().replaceAll("\n", "<br>"));
		}
		
		model.addAttribute("detail", detail);
		model.addAttribute("id", m_id);
		
		// 댓글 목록 구현
		log.info("reviewList 호출 성공");
		log.info("상품 rv " + rvvo.getP_number());
		log.info("상품 p " + pvo.getP_number()); 
			
		model.addAttribute("reviewList", reviewService.reviewList(pvo.getP_number()));
		model.addAttribute("id", m_id); 
		
		return "product/productDetail";
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("여긴 m_id " + m_id);
	}
	
}
