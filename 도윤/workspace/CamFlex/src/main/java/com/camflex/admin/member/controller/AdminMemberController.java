package com.camflex.admin.member.controller;

import java.util.ArrayList;
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
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;
import com.camflex.common.vo.CodeLabelValue;


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
	public void memberList(@ModelAttribute("pgrq") PageRequest pageRequest, LoginVO lvo, Model model) {
		log.info("회원 리스트 호출 성공");
		// 뷰에 페이징 처리를 한 게시글 목록을 전달한다.
		model.addAttribute("memberList", adminMemberService.memberList(pageRequest));
		
		// 페이징 네비게이션 정보를 뷰에 전달한다.
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(adminMemberService.count(pageRequest));
		model.addAttribute("pagination", pagination);
		
		// 검색 유형의 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeCodeValueList = new ArrayList<CodeLabelValue>();
		searchTypeCodeValueList.add(new CodeLabelValue("a", "---"));
		searchTypeCodeValueList.add(new CodeLabelValue("i", "아이디"));
		searchTypeCodeValueList.add(new CodeLabelValue("n", "이름"));
		searchTypeCodeValueList.add(new CodeLabelValue("p", "전화번호"));
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
	}

}
