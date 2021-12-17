package com.camflex.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.member.service.AdminMemberService;
import com.camflex.client.login.vo.LoginVO;

@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {
	
	private Logger log = LoggerFactory.getLogger(AdminMemberController.class);
	
	@Autowired
	private AdminMemberService adminMemberService;
	
	/*******************************
	 * 회원 리스트 구현하기
	 *******************************/
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(@ModelAttribute LoginVO lvo, Model model, HttpServletRequest request) {
		log.info("회원 리스트 호출 성공");
		
		List<LoginVO> memberList = adminMemberService.memberList(lvo);
		
		model.addAttribute("memberList", memberList);
		
		return "admin/member/memberList";
	}
	
}
