package com.camflex.client.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.camflex.client.login.service.LoginService;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	private HttpSession session;
	private String m_id;
	
	/* 로그인 페이지 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("Login GET 호출 성공");
		
		return "login/login"; // views/login/login.jsp로 포워드
	}

	/* 로그인 기능 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(LoginVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		sessionCheck(request, response);
		log.info("접속한 ID = " + m_id);
		
		log.info("Login POST 호출 성공");
		
		session = request.getSession();
		LoginVO login = loginService.loginCheck(vo);

		if (login == null) {
			log.info("login false");
			session.setAttribute("login", null);
			rttr.addFlashAttribute("msg", false);
			return "/login/login";
		} else {
			log.info("login Success");
			session.setAttribute("m_id", vo.getM_id());
			return "redirect:/";
		}
	}

	/* 아이디 찾기 페이지 */
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findIdForm() {
		log.info("FindId GET 호출 성공");
		
		return "login/findId"; 
	}

	/* 아이디 찾기 */
	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public String findId(MemberVO vo, Model model, RedirectAttributes rttr) throws Exception {
		log.info("FindId POST 호출 성공");
		
		MemberVO mvo = loginService.findId(vo);

		if (mvo == null) {
			log.info("find ID 실패");
			model.addAttribute("mvo", null);
			rttr.addFlashAttribute("msg", false);
			
			return "login/findId";
		} else {
			log.info("find ID 성공");
			model.addAttribute("mvo", mvo);

			return "login/findId";
		}
	}

	/* 비밀번호 찾기 페이지 */
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPwForm() {
		log.info("FindPw GET 호출 성공");
		
		return "login/findPw"; // views/login/findPw.jsp로 포워드
	}

	/* 비밀번호 찾기 */
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPwForm(MemberVO vo, Model model, RedirectAttributes rttr) throws Exception {
		log.info("FindPw POST 호출 성공");
		MemberVO mvo1 = loginService.findPw(vo);

		if (mvo1 == null) {
			log.info("find PW 실패");
			model.addAttribute("mvo1", null);
			rttr.addFlashAttribute("msg", false);
			
			return "login/findPw";
		} else {
			log.info("find PW 성공");
			model.addAttribute("mvo1", mvo1);
			
			return "login/findPw";
		}	
	}
	
	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session, HttpServletRequest request) throws Exception {
		log.info("LogOut");
		
		session.invalidate();
		session = request.getSession(true);
		
		return "redirect:/";
	}
	
	// 로그인 체크
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("여긴 m_id " + m_id);
	}

}
