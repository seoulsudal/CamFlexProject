package com.camflex.client.main.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private Logger log = LoggerFactory.getLogger(MainController.class);
	
	private HttpSession session;
	private String m_id;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("캠플렉스에 오신걸 환영합니다.");
		
		model.addAttribute("id", m_id);
					
		return "index";
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("여긴 m_id " + m_id);
	}
	
}
