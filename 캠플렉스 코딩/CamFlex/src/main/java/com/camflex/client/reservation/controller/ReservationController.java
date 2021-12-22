package com.camflex.client.reservation.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.client.reservation.service.ReservationService;
import com.camflex.client.reservation.vo.ReservationVO;

import oracle.jdbc.logging.annotations.Log;

@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {

	private Logger log = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private ReservationService reservationService;

	/* 실시간 예약 폼 */
	@RequestMapping(value = "/reservationDetail", method = RequestMethod.POST)
	public String reservationDetail(@ModelAttribute AdminProductVO pvo, ReservationVO rvo, Model model) throws Exception {
		log.info("reservationDetail 호출 성공");
		log.info("P_number = " + pvo.getP_number());
		log.info("P_name = " + pvo.getP_name());
		log.info("P_price = " + pvo.getP_price());
		log.info("m_id = " + rvo.getM_id());

		List<ReservationVO> reservationList = reservationService.reservationList(rvo);
				
		// JAVA 8 이후 나온 달력 쓰는 클래스
		LocalDate localDate;
		YearMonth yearMonth;
		int monthEndFirst, monthStartFirst, monthEndSecond, monthStartSecond;
		int year, month, yearNext, monthNext;
		int today;

		localDate = LocalDate.now();
		yearMonth = YearMonth.now();
		year = localDate.getYear();
		month = localDate.getMonth().getValue();
		monthEndFirst = yearMonth.atEndOfMonth().getDayOfMonth();
		monthStartFirst = yearMonth.atDay(1).getDayOfWeek().getValue();
		today = localDate.getDayOfMonth();

		yearNext = year;
		monthNext = month + 1;

		// 해당 12월달 다음은 내년 1월
		if (monthNext > 12) {
			yearNext += 1;
			monthNext = 1;
		}

		yearMonth = YearMonth.of(yearNext, monthNext);
		monthEndSecond = yearMonth.atEndOfMonth().getDayOfMonth();
		monthStartSecond = yearMonth.atDay(1).getDayOfWeek().getValue();

		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("monthEndFirst", monthEndFirst);
		model.addAttribute("monthStartFirst", monthStartFirst);
		model.addAttribute("today", today);

		model.addAttribute("yearNext", yearNext);
		model.addAttribute("monthNext", monthNext);
		model.addAttribute("monthEndSecond", monthEndSecond);
		model.addAttribute("monthStartSecond", monthStartSecond);

		model.addAttribute("reservationList", reservationList);
		model.addAttribute("detail", pvo);
		model.addAttribute("reservation", rvo);

		return "reservation/reservationDetail";
	}

	/* 실시간 예약 동의페이지 */
	@RequestMapping(value = "/reservationAgreePage", method = RequestMethod.POST)
	public String reservationAgreePageForm(@ModelAttribute AdminProductVO pvo, ReservationVO rvo, Model model) throws Exception {
		log.info("reservationAgreePageForm 호출 성공");
		log.info("P_number = " + pvo.getP_number());
		log.info("P_name = " + pvo.getP_name());
		log.info("P_price = " + pvo.getP_price());
		log.info("R_startDate = " + rvo.getR_startDate());
		log.info("R_endDate = " + rvo.getR_endDate());
		// 예약 일수 계산
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date start = transFormat.parse(rvo.getR_startDate());
		java.util.Date end = transFormat.parse(rvo.getR_endDate());
		long startDate = start.getTime();
		long endDate = end.getTime();
		long resultDate = (endDate - startDate)/(1000*60*60*24);
		log.info("예약 일수 = " + resultDate + " 일");

		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("detail", pvo);
		model.addAttribute("reservation", rvo);
		model.addAttribute("resultDate", resultDate);

		return "reservation/reservationAgreePage";
	}
	
	/* 실시간 예약 생성 */	
	@RequestMapping(value = "reservationRegister", method = RequestMethod.POST)
	public String reservationRegister(@ModelAttribute AdminProductVO pvo, ReservationVO rvo, Model model) throws Exception {
		log.info("reservationRegister 호출 성공");
		log.info("P_number = " + pvo.getP_number());
		log.info("P_price = " + pvo.getP_price());
		log.info("R_startDate = " + rvo.getR_startDate());
		log.info("R_endDate = " + rvo.getR_endDate());
		// 예약 일수 계산
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date start = transFormat.parse(rvo.getR_startDate());
		java.util.Date end = transFormat.parse(rvo.getR_endDate());
		long startDate = start.getTime();
		long endDate = end.getTime();
		long resultDate = (endDate - startDate)/(1000*60*60*24);
		log.info("예약 일수 = " + resultDate + " 일");
		log.info("R_price = " + rvo.getR_price());
		log.info("m_id = " + rvo.getM_id());
		
		int result = 0;
		String url = "";
		
		result = reservationService.register(rvo);
		if(result == 1) {
			url = "/product/productList";
		} else {
			model.addAttribute("code", 1);
			url = "/product/productList";
		}
		
		return "redirect:" + url;
	}
	 

}
