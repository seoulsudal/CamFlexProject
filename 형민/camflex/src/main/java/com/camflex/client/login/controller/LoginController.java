package com.camflex.client.login.controller;

import javax.inject.Inject;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camflex.client.login.service.LoginService;

import com.camflex.client.login.vo.LoginVO;

@Controller
public class LoginController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Inject
	LoginService loginService;

	/* 로그인 화면 */
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String LoginForm() {
		log.info("loginForm.do get 성공");
		return "/login/loginForm"; // views/login/loginForm.jsp로 포워드
	}

	/* 로그인 처리 2 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		log.info("로그인 처리 POST");
		log.info(vo.getM_id() + vo.getM_pw());
		System.out.println("0");
		LoginVO loginVO = loginService.loginSelect(vo);
		System.out.println("0-1");
		log.info("리턴VO결과(서비스에서 예외처리를 진행했으므로 null이 출력되면 코드에 문제있다는 의미) " + loginVO);

		if (loginVO != null) {
			session.setAttribute("m_id", loginVO.getM_id());
			rttr.addFlashAttribute("mvo", loginVO);

			log.info("로그인 성공");
			return "/listMember";
		} else {
			log.info("로그인 실패");
			return "/login/loginForm";
		}
	}
}
