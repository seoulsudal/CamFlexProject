package com.camflex.admin.chart.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminChartDAOImpl implements AdminChartDAO {
	
	@Autowired
	private SqlSession sqlsession;

	@Override
	public Map<String, Integer> campingZone() {
		
		return sqlsession.selectMap("campinZone", "");
	}

	
	@Override
	public Map<String, Integer> monthlySales() {
	  
		return sqlsession.selectMap("monthlySales", "");
	}
	

	
	@Override public Map<String, Integer> cancel() {
	 
		return sqlsession.selectMap("cancel", "");
	
	}
	
}
