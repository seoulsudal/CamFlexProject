package com.camflex.admin.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camflex.admin.login.service.AdminLoginService;
import com.camflex.client.login.vo.LoginVO;

@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {

	private Logger log = LoggerFactory.getLogger(AdminLoginController.class);

	@Autowired
	private AdminLoginService adminLoginService;

	private HttpSession session;
	private String m_id;

	/*****************************
	 * 로그인 페이지
	 *****************************/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);

		log.info("관리자 Login GET 호출 성공");

		return "admin/login/login"; // /admin/login.jsp로 포워드
	}

	/***************************
	 * 로그인 기능
	 ***************************/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);

		log.info("Login POST 호출 성공");

		session = request.getSession();
		LoginVO login = adminLoginService.loginCheck(vo);

		if (login == null) {
			log.info("login false");
			session.setAttribute("login", null);
			rttr.addFlashAttribute("msg", false);
			return "admin/login/login";
		} else {
			log.info("login Success");
			session.setAttribute("m_id", vo.getM_id());

			return "redirect:/admin/main";
		}
	}

	/*****************************
	 * 로그아웃
	 *****************************/
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) throws Exception {
		log.info("LogOut");

		session.invalidate();
		session = request.getSession(true);

		return "redirect:/";
	}

	/*****************************
	 * 로그인 체크
	 ****************************/
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id : " + m_id);
	}
	
}
