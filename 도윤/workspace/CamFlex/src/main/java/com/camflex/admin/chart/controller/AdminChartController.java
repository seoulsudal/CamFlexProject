package com.camflex.admin.chart.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camflex.admin.chart.service.AdminChartService;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.graph.ChartMake;

@Controller
@RequestMapping("/admin/chart")
public class AdminChartController {

	private Logger log = LoggerFactory.getLogger(AdminChartController.class);
	
	@Autowired
	private AdminChartService adminChartService;
	
	// 차트 출력
	@RequestMapping(value = "/chartList")
	public String chart(@ModelAttribute ReservationVO rvo, Model model, HttpServletRequest request) {
		log.info("차트페이지 호출 성공");
		
		// 캠핑존별 
		Map<String, Integer>campingZone = adminChartService.campingZone();
		ChartMake.pieChart(request, campingZone);
		
		// 매출
	
		Map<String, Integer>monthlySales = adminChartService.monthlySales();
		ChartMake.barChart(request, monthlySales);
		
		// 취소 사유
		Map<String, Integer>cancel = adminChartService.cancel();
		ChartMake.barChart2(request, cancel);
		
		
		return "admin/chart/chartList";
	}
}
