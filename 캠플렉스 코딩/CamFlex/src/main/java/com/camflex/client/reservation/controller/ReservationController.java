package com.camflex.client.reservation.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;

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
	public String reservationDetail(@ModelAttribute AdminProductVO pvo,ReservationVO rvo, Model model) throws Exception {
		log.info("reservationDetail 호출 성공");
		log.info("P_number = " + pvo.getP_number());
		log.info("P_name = " + pvo.getP_name());
		log.info("P_price = " + pvo.getP_price());
		
		// JAVA 8 이후 나온 달력 쓰는 클래스
		LocalDate localDate = LocalDate.now();
		YearMonth yearMonth = YearMonth.now();
		int monthEndFirst, monthStartFirst, monthEndSecond, monthStartSecond;
		int year, month, yearNext, monthNext;
		int today;
		
		year = localDate.getYear();
		month = localDate.getMonth().getValue();
		monthEndFirst = yearMonth.atEndOfMonth().getDayOfMonth();
		monthStartFirst = yearMonth.atDay(1).getDayOfWeek().getValue();
		today = localDate.getDayOfMonth();
		
		yearNext = year;
		monthNext = month+1;
		
		// 해당 12월달 다음은 내년 1월
		if(monthNext > 12) {
			yearNext+=1;
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
		

		model.addAttribute("detail", pvo);
		
		return "reservation/reservationDetail";
	}

	/* 실시간 예약 생성 */
	@RequestMapping(value = "/reservationAgreePage", method = RequestMethod.POST)
	public String reservationAgreePage() {
		log.info("reservationAgreePage 호출 성공");
		
		return "reservation/reservationAgreePage";
	}

}
