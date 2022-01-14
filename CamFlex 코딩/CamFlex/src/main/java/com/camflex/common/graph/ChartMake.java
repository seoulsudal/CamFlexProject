package com.camflex.common.graph;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.camflex.common.file.FileUploadUtil;

public class ChartMake {

	private static Logger log = LoggerFactory.getLogger(ChartMake.class);
	
	public static void barChart1(HttpServletRequest request, Map<String, Integer>resultMap) {
		String docRoot = request.getSession().getServletContext().getRealPath("/graph");
		FileUploadUtil.makeDir(docRoot);
		
		log.info("업로드할 파일 경로(docRoot) : " + docRoot);
		
		File file = new File(docRoot + "/barChart1.jpg");
		FileOutputStream fos = null;
		
		try {
			// 데이터로 사용할 카테고리 데이터 셋을 생성
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			
			for(Map.Entry<String, Integer>result : resultMap.entrySet()) {
				log.info(result.getKey() + "=" + result.getValue());
				dataset.addValue(result.getValue(), result.getKey(), result.getKey());
			}
			JFreeChart chart = ChartFactory.createBarChart("월별 매출", "개월", "매출액(단위 : 원)", dataset, PlotOrientation.VERTICAL, true, true, false);
			
			chart.setBackgroundPaint(Color.white);
			chart.getTitle().setFont(new Font("sansserif", Font.BOLD,16));
			
			Font font = new Font("sansserif", Font.BOLD, 12);
			chart.getLegend().setItemFont(font);
			
			CategoryPlot plot = chart.getCategoryPlot();
			// X축 라벨
			plot.getDomainAxis().setLabelFont(font);	// 개월
			// X출 도메인
			plot.getDomainAxis().setTickLabelFont(font);//  2개월, 1개월, 이번달
			// Y축 라벨
			plot.getRangeAxis().setLabelFont(font);		// 매출금액
			// Y출 범위
			plot.getRangeAxis().setTickLabelFont(font);
			
			fos = new FileOutputStream(file);
			
			ChartUtilities.writeChartAsJPEG(fos, chart, 500, 280);
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				if(fos != null)fos.close();
			}catch(IOException e) {
				e.getMessage();
			}
		}
	}
	public static void barChart2(HttpServletRequest request, Map<String, Integer>resultMap) {
		String docRoot = request.getSession().getServletContext().getRealPath("/graph");
		FileUploadUtil.makeDir(docRoot);
		
		log.info("업로드할 파일 경로(docRoot) : " + docRoot);
		
		File file = new File(docRoot + "/barChart2.jpg");
		FileOutputStream fos = null;
		
		try {
			// 데이터로 사용할 카테고리 데이터 셋을 생성
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			
			for(Map.Entry<String, Integer>result : resultMap.entrySet()) {
				log.info(result.getKey() + "=" + result.getValue());
				dataset.addValue(result.getValue(), result.getKey(), result.getKey());
			}
			JFreeChart chart = ChartFactory.createBarChart("취소 사유", "사유", "단위(건)", dataset, PlotOrientation.VERTICAL, true, true, false);
			
			chart.setBackgroundPaint(Color.white);
			chart.getTitle().setFont(new Font("sansserif", Font.BOLD,16));
			
			Font font = new Font("sansserif", Font.BOLD, 12);
			chart.getLegend().setItemFont(font);
			
			CategoryPlot plot = chart.getCategoryPlot();
			// X축 라벨
			plot.getDomainAxis().setLabelFont(font);	// 개월
			// X출 도메인
			plot.getDomainAxis().setTickLabelFont(font);//  2개월, 1개월, 이번달
			// Y축 라벨
			plot.getRangeAxis().setLabelFont(font);		// 매출금액
			// Y출 범위
			plot.getRangeAxis().setTickLabelFont(font);
			
			fos = new FileOutputStream(file);
			
			ChartUtilities.writeChartAsJPEG(fos, chart, 500, 280);
		}catch(Exception e) {
			e.getMessage();
		}finally {
			try {
				if(fos != null)fos.close();
			}catch(IOException e) {
				e.getMessage();
			}
		}
	}
	
	public static void pieChart(HttpServletRequest request, Map<String, Integer>resultMap) {
		String docRoot = request.getSession().getServletContext().getRealPath("/graph");
		FileUploadUtil.makeDir(docRoot);
		log.info("업로드 할 파일 경로(docRoot) : " + docRoot);
		
		File file = new File(docRoot + "/pieChart.jpg");
		FileOutputStream fos = null;
		
		try {
			DefaultPieDataset dataset = new DefaultPieDataset();
			
			for(Map.Entry<String, Integer>result : resultMap.entrySet()) {
				log.info(result.getKey() + "=" + result.getValue());
				dataset.setValue(result.getKey(), result.getValue());
			}
			
			JFreeChart chart = ChartFactory.createPieChart("캠핑존 별 통계", dataset, true, true, false);
			chart.setBackgroundPaint(Color.white);
			chart.getTitle().setFont(new Font("sansserif", Font.BOLD, 16));
			chart.getLegend().setItemFont(new Font("sansserif", Font.BOLD, 12));
			
			PiePlot plot = (PiePlot) chart.getPlot();
			plot.setLabelFont(new Font("sansserif", Font.BOLD, 14));
			
			fos = new FileOutputStream(file);
			ChartUtilities.writeChartAsJPEG(fos, chart, 480, 280);
			
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
			if(fos != null) {
				try {
					fos.close();
				}catch(IOException e) {
					e.getMessage();
				}
			}
		}
	}
}
