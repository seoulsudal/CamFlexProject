package com.camflex.admin.chart.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.chart.dao.AdminChartDAO;

@Service
@Transactional
public class AdminChartServiceImpl implements AdminChartService {

	@Autowired
	private AdminChartDAO adminChartDAO;

	// 캠핑존 별
	@Override
	public Map<String, Integer> campingZone() {
		Map<String, Integer>campList = null;
		campList = adminChartDAO.campingZone();
		return campList;
	}

	// 월별
	@Override
	public Map<String, Integer> monthlySales() { 
		Map<String, Integer>sales = null;
		sales = adminChartDAO.monthlySales();
		return sales; 
	}
	// 취소 사유 별
	@Override public Map<String, Integer> cancel() { 
		Map<String, Integer>cancel = null; 
		
		cancel = adminChartDAO.cancel();
		
		return cancel; }
	
}
