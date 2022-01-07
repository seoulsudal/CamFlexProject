package com.camflex.client.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.client.member.service.MemberService;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.util.BCrypt;
import com.camflex.common.util.SHA256;

@Controller
public class MemberController {
	// 로깅을 위한 변수
	private Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@Autowired
	private BCryptPasswordEncoder pwEncoder;

	/* 회원가입 폼 */
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String joinForm() {
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
		log.info("회원가입 처리 완료");
		return "/member/insert";
	}

}
