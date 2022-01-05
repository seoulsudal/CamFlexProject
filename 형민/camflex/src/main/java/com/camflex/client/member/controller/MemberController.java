package com.camflex.client.member.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.member.service.MemberService;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(MemberController.class);

	private HttpSession session;
	private String m_id;
	private int r_number;

	@Autowired
	private MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	/* 회원가입 폼 */
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
		log.info("---------------");
		log.info("joinForm.do get 성공");
		return "/member/join";
	}

	/* 회원가입 처리 (BCryptPasswordEncoder 사용) */
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(MemberVO vo) throws Exception {
		String m_pw = ""; // 인코딩 전 비밀번호
		String encodePw = ""; // 인코딩 후 비밀번호

		m_pw = vo.getM_pw(); // 비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(m_pw); // 비밀번호 인코딩
		vo.setM_pw(encodePw); // 인코딩된 비밀번호 member객체에 다시 저장

		/* 회원가입 쿼리 실행 */
		memberService.insertMember(vo);
		log.info("---------------");
		log.info("회원가입 처리 완료");
		return "/member/insert";
	}

	/* 내 정보 조회 */
	@RequestMapping(value = "/MemberDate", method = RequestMethod.GET)
	public String memberDate(@ModelAttribute MemberVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) throws Exception {
		log.info("---------------");
		log.info("내 정보 조회");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/MemberDate";
	}

	/* 비밀번호 인증 페이지 */
	@RequestMapping(value = "/PwCheckForm", method = RequestMethod.GET)
	public String PwCheckForm(@ModelAttribute MemberVO vo, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		log.info("---------------");
		log.info("PwCheckForm.do get 성공");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/pwCheck";
	}

	/* 내 정보 수정 페이지로 이동하기 위한 비밀번호 인증 */
	@RequestMapping(value = "/PwCheck", method = RequestMethod.POST)
	public String pwCheck(MemberVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		log.info("---------------");
		log.info("비밀번호 인증 ");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");
		MemberVO mvo = memberService.PwCheck(vo);

		if (mvo == null) {
			log.info("비밀번호 인증 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');</script>");
			out_equals.flush();
			log.info("다시 인증 페이지로");

		} else {
			log.info("비밀번호 인증 성공");
			model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));
			return "/member/MemberModify";
		}
		return "/member/pwCheck";
	}

	/* 내 정보 수정 하기 폼 */
	@RequestMapping(value = "/MemberModifyForm", method = RequestMethod.GET)
	public String memberModifyForm(@ModelAttribute MemberVO vo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) throws Exception {
		log.info("---------------");
		log.info("내 정보 수정 폼");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/MemberModify";
	}

	/* 내 정보 수정 하기 */
	@RequestMapping(value = "/MemberModify", method = RequestMethod.POST)
	public String memberModify(MemberVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) throws Exception {

		log.info("---------------");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");
		MemberVO mvo = new MemberVO();
		mvo = memberService.MemberModify(vo);

		if (mvo == null) {
			log.info("개인정보 수정 실패");

			return "/member/MemberModify";
		} else {
			log.info("개인정보 수정 성공");
			model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));
			return "redirect:/member/MemberDate";

		}

	}

	/* 내 예약 정보 조회 페이지 */
	@RequestMapping(value = "/ReserveList", method = RequestMethod.GET)
	public String ReserveList(@ModelAttribute MemberVO vo, @ModelAttribute PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
		log.info("내 예약 정보");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		pageRequest.setM_id(m_id);

		model.addAttribute("reserveList", memberService.reserveList(pageRequest));
		model.addAttribute("m_id", m_id);

		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(memberService.count(pageRequest));
		model.addAttribute("pagination", pagination);

		return "/member/ReserveList";
	}

	/* 예약 취소 페이지 */
	@RequestMapping(value = "/ReserveCancel", method = RequestMethod.GET)
	public String ReserveCancel(@ModelAttribute ReservationVO rvo, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		log.info("예약 취소 페이지");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");
		log.info("취소할 예약 번호 : " + r_number);

		rvo.setM_id(m_id);

		model.addAttribute("reserveList", memberService.reserveCancel(rvo));
		model.addAttribute("m_id", m_id);

		return "/member/ReserveCancel";
	}

	/* 예약 취소 처리 */
	@RequestMapping(value = "/Cancel")
	public String Cancel(@ModelAttribute ReservationVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		log.info("예약 취소 처리");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		log.info("예약 번호 : " + vo.getR_number());

		int result = 0;
		result = memberService.Cancel(vo);

		if (result == 1) {
			log.info("예약 취소 완료");
		} else {
			log.info("예약 취소 실패");
			return "/member/reserveCancel";
		}
		return "/member/ReserveList";

	}

	// 로그인 체크 & 세션 유지
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message)
			throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("접속한 ID = " + m_id);

		if (m_id == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('" + message + "');");
			out.println("location.href='/login/login'");
			out.println("</script>");
			out.flush();
		}
	}
}
