package com.camflex.admin.chart.controller;

import java.io.PrintWriter;
import java.util.Map;

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

import com.camflex.admin.chart.service.AdminChartService;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.graph.ChartMake;

@Controller
@RequestMapping("/admin/chart")
public class AdminChartController {

	private Logger log = LoggerFactory.getLogger(AdminChartController.class);

	private HttpSession session;
	private String m_id;

	@Autowired
	private AdminChartService adminChartService;

	// 차트 출력
	@RequestMapping(value = "/chartList")
	public String chart(@ModelAttribute ReservationVO rvo, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("차트페이지 호출 성공");

		model.addAttribute("id", m_id);
		
		// 캠핑존별
		Map<String, Integer> campingZone = adminChartService.campingZone();
		ChartMake.pieChart(request, campingZone);

		// 매출
		Map<String, Integer> monthlySales = adminChartService.monthlySales();
		ChartMake.barChart1(request, monthlySales);

		// 취소 사유
		Map<String, Integer> cancel = adminChartService.cancel();
		ChartMake.barChart2(request, cancel);

		return "admin/chart/chartList";
	}

	/****************************
	 * 로그인 체크
	 ***************************/
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message)
			throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id : " + m_id);

		if (m_id == null) {
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
