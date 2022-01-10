package com.camflex.client.member.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinForm() {
		return "/member/join";
	}

	/* 회원가입 처리 (BCryptPasswordEncoder 사용) */
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(@ModelAttribute MemberVO mvo, Model model) throws Exception {
		String m_pw = ""; // 인코딩 전 비밀번호
		String encodePw = ""; // 인코딩 후 비밀번호

		m_pw = mvo.getM_pw(); // 비밀번호 데이터 얻음
		encodePw = pwEncoder.encode(m_pw); // 비밀번호 인코딩
		mvo.setM_pw(encodePw); // 인코딩된 비밀번호 member객체에 다시 저장

		memberService.insertMember(mvo);

		return "redirect:/";
	}

	/* 내 정보 조회 */
	@RequestMapping(value = "/MemberDate", method = RequestMethod.GET)
	public String memberDate(@ModelAttribute MemberVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) throws Exception {
		log.info("내 정보 조회");
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/MemberDate";
	}

	/* 내 정보 조회 비밀번호 인증 페이지 */
	@RequestMapping(value = "/PwCheckForm", method = RequestMethod.GET)
	public String PwCheckForm(@ModelAttribute MemberVO vo, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/pwCheck";
	}

	/* 내 정보 수정 페이지로 이동하기 위한 비밀번호 인증 기능 */
	@RequestMapping(value = "/PwCheck", method = RequestMethod.POST)
	public String pwCheck(MemberVO vo, HttpSession session, HttpServletRequest request, HttpServletResponse response,
			Model model) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		MemberVO mvo = memberService.PwCheck(vo);

		if (mvo == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out_equals = response.getWriter();
			out_equals.println("<script>alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');</script>");
			out_equals.flush();

		} else {
			model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));
			return "/member/MemberModify";
		}
		return "/member/pwCheck";
	}

	/* 내 정보 수정 하기 폼 */
	@RequestMapping(value = "/MemberModifyForm", method = RequestMethod.GET)
	public String memberModifyForm(@ModelAttribute MemberVO vo, HttpServletRequest request,
			HttpServletResponse response, HttpSession session, Model model) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));

		return "/member/MemberModify";
	}

	/* 내 정보 수정 하기 */
	@RequestMapping(value = "/MemberModify", method = RequestMethod.POST)
	public String memberModify(MemberVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, Model model) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		MemberVO mvo = new MemberVO();
		mvo = memberService.MemberModify(vo);

		if (mvo == null) {

			return "/member/MemberModify";
		} else {
			model.addAttribute("memberVO", memberService.readMember((String) session.getAttribute("m_id")));
			return "redirect:/member/MemberDate";

		}

	}

	/* 내 예약 정보 조회 페이지 */
	@RequestMapping(value = "/ReserveList", method = RequestMethod.GET)
	public String ReserveList(@ModelAttribute MemberVO vo, @ModelAttribute PageRequest pageRequest,
			HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model)
			throws Exception {
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

	/* 예약 취소 페이지 (특정 예약 건 상세호출) */
	@RequestMapping(value = "/ReserveCancel", method = RequestMethod.GET)
	public String ReserveCancel(@ModelAttribute ReservationVO rvo, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

		double fee;
		int total_price;
		/* 오늘 시간 설정 */
		long today = System.currentTimeMillis();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(today);

		long startDate = rvo.getR_startDate().getTime();
		long resultDate = (startDate - today) / (1000 * 60 * 60 * 24);
		int result = Long.valueOf(resultDate).intValue();

		switch (result) {

		case 7:
		case 6:
			fee = 0.2;
			break;
		case 5:
		case 4:
			fee = 0.3;
			break;
		case 3:
		case 2:
			fee = 0.4;
			break;
		case 1:
			fee = 0.5;
			break;
		default:
			fee = 0;
			break;
		}

		double price_fee = (rvo.getR_price() * fee);
		int p_fee = (int) Math.round(price_fee);

		total_price = rvo.getR_price() - p_fee;

		model.addAttribute("m_id", m_id);
		model.addAttribute("r_number", rvo.getR_number());
		model.addAttribute("r_price", rvo.getR_price());
		model.addAttribute("r_startDate", rvo.getR_startDate());
		model.addAttribute("resultDate", resultDate);
		model.addAttribute("p_fee", p_fee);
		model.addAttribute("total_price", total_price);

		return "/member/ReserveCancel";
	}

	/* 예약 취소 처리 */
	@RequestMapping(value = "/Cancel")
	public String Cancel(@ModelAttribute ReservationVO vo, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) throws Exception {
		session = request.getSession();
		sessionCheck(request, response, "로그인 후 확인 가능합니다.");
		m_id = (String) session.getAttribute("m_id");

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
