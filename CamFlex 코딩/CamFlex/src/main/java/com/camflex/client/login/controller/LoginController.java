package com.camflex.client.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

	/* 이메일 */
	@Autowired
	private JavaMailSenderImpl mailSender;

	/* 암호화 */
	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	/* 로그인 페이지 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		sessionCheck(request, response);
		session = request.getSession();

		return "login/login"; // views/login/login.jsp로 포워드
	}

	/* 로그인 기능 */
	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(LoginVO vo, HttpServletRequest request, HttpServletResponse response, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		sessionCheck(request, response);
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id = " + m_id);

		LoginVO login = loginService.loginCheck(vo);

		if (login != null) {

			log.info("login Success");
			session.setAttribute("m_id", vo.getM_id());
			session.setAttribute("login", login);
			log.info(m_id);
			return "redirect:/";

		} else {
			log.info("login false");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('입력하신 아이디, 비밀번호가 일치하지 않습니다. 다시 입력해주세요.');</script>");
			out_equals.flush();

		}
		return "login/login";
	}

	/* 아이디 찾기 페이지 */
	@RequestMapping(value = "/findId", method = RequestMethod.GET)
	public String findIdForm() {
		log.info("FindId GET 호출 성공");

		return "login/findId";
	}

	/* 아이디 찾기 */
	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public String findId(MemberVO vo, Model model, HttpServletResponse response, RedirectAttributes rttr)
			throws Exception {
		log.info("findId post");
		MemberVO mvo = loginService.findId(vo);

		if (mvo == null) {
			log.info("find ID 실패");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('입력하신 이름, 전화번호가 일치하지 않습니다. 다시 입력해주세요.');</script>");
			out_equals.flush();

			model.addAttribute("mvo", null);
			rttr.addFlashAttribute("msg", false);
			return "login/findId";
		} else {
			log.info("find ID 성공");
			model.addAttribute("mvo", mvo);
		}
		return "login/findId";
	}

	/* 비밀번호 찾기 페이지 */
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public String findPwForm() {
		log.info("비밀번호 찾기 페이지 호출 성공");
		return "login/findPw"; // views/login/findPw.jsp로 포워드
	}

	/* 비밀번호 찾기 인증번호 이메일 발송 기능 */
	/* 이름과 아이디, 전화번호로 인증받는다. */
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public ModelAndView findPw(Model model, HttpServletResponse response, HttpServletRequest request, MemberVO vo,
			RedirectAttributes rttr) throws Exception {

		String m_id = (String) request.getParameter("m_id");
		String m_name = (String) request.getParameter("m_name");

		ModelAndView mav = new ModelAndView(); // ModelAndView로 보낼 페이지 지정
		// 비밀번호 찾기 (이름,아이디)인증
		MemberVO mvo = loginService.IdName(vo);
		if (mvo != null) {

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('입력하신 이름, 아이디가 일치하지 않습니다. 다시 입력해주세요.');</script>");
			out_equals.flush();

			mav.setViewName("/login/findPw");

			return mav;

		} else {
			Random r = new Random();
			int dice = r.nextInt(157211) + 48271;

			String setfrom = "dlgudals0011@gmail.com"; // 보내는 사람(사이트 관리자)
			String tomail = request.getParameter("m_id"); // 받는 사람의 이메일(아이디 m_id)
			String title = "camflex 캠핑장에서 인증번호를 보냅니다!"; // 제목
			String content =
					// 메일 내용
					System.getProperty("line.separator") + System.getProperty("line.separator") + "안녕하십니까!"
							+ System.getProperty("line.separator") + System.getProperty("line.separator")
							+ "요청하신 인증번호는 " + dice + " 입니다." + System.getProperty("line.separator")
							+ System.getProperty("line.separator") + "받으신 인증번호를 홈페이지에 입력해 주시면 비밀번호 수정 페이지로 넘어갑니다 :)";

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

				messageHelper.setFrom(setfrom); // 보내는 사람 생략하면 정상작동X
				messageHelper.setTo(tomail); // 받는 사람 이메일(아이디 m_id)
				messageHelper.setSubject(title); // 메일제목은 생략 가능
				messageHelper.setText(content);// 메일 내용

				mailSender.send(message);

			} catch (Exception e) {
				System.out.println(e);
			}

			mav.addObject("dice", dice);
			mav.addObject("m_id", m_id);
			mav.setViewName("/login/findPw_CCN"); // 인증번호 입력.jsp 뷰

			log.info("--발송한 인증번호--");
			log.info("ID : " + m_id);
			log.info("dice : " + dice);
			log.info("mav : " + mav);
			log.info("---------------");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_m_id = response.getWriter();
			out_m_id.println("<script>alert('이메일이 발송되었습니다. 인증번호를 입력해주세요.');</script>");
			out_m_id.flush();

		}

		return mav;

	}

	/* 인증번호 받고 인증하는 페이지 */
	// Certification Number = CCN 인증번호
	@RequestMapping(value = "/CCN.do{dice},{m_id}", method = RequestMethod.POST)
	public ModelAndView CCN(String CCN, @PathVariable(value = "dice") String dice,
			@PathVariable(value = "m_id") String m_id, HttpServletResponse response) throws IOException {

		ModelAndView mav = new ModelAndView();

		mav.addObject("m_id", m_id);
		mav.addObject("dice", dice);
		mav.setViewName("/login/findPw_change");

		log.info("찾을려는 ID : " + m_id);
		log.info("입력한 CCN : " + CCN);
		log.info("마지막 dice : " + dice);

		if (CCN.equals(dice)) {
			// 인증번호 일치 시
			mav.addObject("m_id", m_id);
			mav.setViewName("/login/findPw_change");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('인증번호가 일치합니다. 비밀번호 변경 페이지로 이동합니다.');</script>");
			out_equals.flush();

			return mav;
		} else if (CCN != dice) {
			// 인증번호 불일치 시
			ModelAndView mav2 = new ModelAndView();

			mav2.setViewName("/login/findPw_CCN");

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('인증번호가 일치하지 않습니다. 다시 입력해주세요.'); history.go(-1);</script>");
			out_equals.flush();

			return mav2;
		}
		return mav;
	}

	// 비밀번호 변경
	@RequestMapping(value = "/change_pw", method = RequestMethod.POST)
	public String change_pw(MemberVO vo, String m_id, HttpServletResponse response, RedirectAttributes rttr)
			throws Exception {
		log.info("비밀번호 변경 요청");
		log.info("변경한 id : " + m_id);

		/* 인코딩 후 비밀번호 */
		String m_pw = "";// 인코딩 전 비밀번호
		String encodePw = ""; // 변경된 비밀번호 다시 암호화

		m_pw = vo.getM_pw();
		encodePw = pwEncoder.encode(m_pw); // 비밀번호 인코딩
		vo.setM_pw(encodePw);

		/* 암호화 된 비밀번호 변경 */ loginService.change_pw(vo);
		session.invalidate();
		rttr.addFlashAttribute("result", "updateOK");

		log.info("비밀번호 변경 완료");
		return "login/pw_result";

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
