package com.camflex.admin.reservation.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.camflex.admin.reservation.service.AdminReservationService;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.CodeLabelValue;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

@Controller
@RequestMapping(value = "/admin/reservation")
public class AdminReservationController {

	
	private Logger log = LoggerFactory.getLogger(AdminReservationController.class);
	
	@Autowired
	private AdminReservationService adminReservationService;

	private HttpSession session;
	private String m_id;

	
	/****************************
	 * 예약 리스트 조회
	 ***************************/
	@RequestMapping(value = "/reservationList", method = RequestMethod.GET)
	public String reservationList(@ModelAttribute("pgrq") PageRequest pageRequest, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		
		log.info("예약 리스트 호출 성공");
		
		// 뷰에 페이징 처리를 한 예약 목록을 전달한다.
		model.addAttribute("reservationList", adminReservationService.reservationList(pageRequest));
		model.addAttribute("id", m_id);
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminReservationService.count(pageRequest));
		model.addAttribute("pagination", pagination);
		
		//검색 유형의 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("a", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("m", "아이디"));
		searchTypeCodeValueList.add(new CodeLabelValue("d", "날짜검색"));
		searchTypeCodeValueList.add(new CodeLabelValue("t", "오늘날짜"));
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
		
		return "admin/reservation/reservationList";
	}
	
	/**************************
	 * 신규 예약 리스트 출력
	 **************************/
	@RequestMapping(value = "/newReservation", method = RequestMethod.GET)
	public String newRsvList(@ModelAttribute PageRequest pageRequest, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		
		
		log.info("신규 예약 리스트 호출");
		
		// List<ReservationVO> newRsvList = adminReservationService.newRsvList(rvo);
		
		model.addAttribute("newRsvList", adminReservationService.newRsvList(pageRequest));
		model.addAttribute("id", m_id);
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminReservationService.count1(pageRequest));
		model.addAttribute("pagination", pagination);
		
		// 검색 유형의 코드명과 코드값을 정의한다.
		
		//List<CodeLabelValue> searchTypeCodeValueList = new
		//ArrayList<CodeLabelValue>(); searchTypeCodeValueList.add(new
		//CodeLabelValue("a", "---")); searchTypeCodeValueList.add(new
		//CodeLabelValue("m", "아이디")); searchTypeCodeValueList.add(new
		//CodeLabelValue("se", "시작일 or 종료일"));
		//model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
		
		
		return "admin/reservation/newReservation";
	}
	/************************
	 * 신규 예약 리스트 승인 구현
	 ***********************/
	@RequestMapping(value = "/confirmRsv")
	public String confirmRsv(@ModelAttribute ReservationVO rvo) {
		log.info("예약 승인");
		
		log.info("예약 번호 : " + rvo.getR_number());
		int result = 0;
		String url = "";
		
		result = adminReservationService.confirmRsv(rvo);
		
		if(result == 1) {
			System.out.println("승인 성공");
			url = "/admin/reservation/newReservation";
		}
		else {
			System.out.println("승인 실패");
			url = "/admin/reservation/newReservation";
		}

		return "redirect:" + url;
	}
	
	/************************
	 * 신규 예약 취소 구현
	 ************************/
	@RequestMapping(value = "/cancelRsv")
	public String cancelRsv(@ModelAttribute ReservationVO rvo) {
		log.info("예약 취소");
		log.info("예약 번호: " + rvo.getR_number());
		
		int result = 0;
		String url = "";
		
		result = adminReservationService.cancelRsv(rvo);
		
		if(result == 1) {
			System.out.println("취소가 성공적으로 이루어졌습니다.");
			url = "/admin/reservation/newReservation";
		}
		else {
			System.out.println("취소를 실패했습니다.");
			url = "/admin/reservation/newReservation";
		}
		return "redirect:" + url;
	}

	
	
	/***********************
	 * 예약 취소 리스트
	 **********************/
	@RequestMapping(value = "/reservationCancelList", method = RequestMethod.GET)
	public String reservationCancelList(@ModelAttribute PageRequest pageRequest, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		
		log.info("예약 취소 리스트 호출 성공");
		
		//List<ReservationVO>cancelList = adminReservationService.cancelList(rvo);
		
		model.addAttribute("cancelList", adminReservationService.cancelList(pageRequest));
		model.addAttribute("id", m_id);
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminReservationService.count2(pageRequest));
		model.addAttribute("pagination", pagination);
		
		return "admin/reservation/reservationCancelList";
	}
	/****************************
	 * 로그인 체크
	 ***************************/
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
