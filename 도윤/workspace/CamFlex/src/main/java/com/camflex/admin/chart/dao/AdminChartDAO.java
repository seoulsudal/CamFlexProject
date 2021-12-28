package com.camflex.admin.chart.dao;

import java.util.Map;

public interface AdminChartDAO {

	// 캠핑존별
	public Map<String, Integer> campingZone();
	// 월별
	public Map<String, Integer> monthlySales();
	// 취소사유별
	public Map<String, Integer> cancel();

}
