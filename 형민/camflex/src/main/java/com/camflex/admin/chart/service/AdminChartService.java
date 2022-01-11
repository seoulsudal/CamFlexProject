package com.camflex.admin.chart.service;

import java.util.Map;

public interface AdminChartService {

	// 캠핑존 별
	public Map<String, Integer> campingZone();

	// 월별 매출
	public Map<String, Integer> monthlySales();

	// 취소 사유
	public Map<String, Integer> cancel();

}
