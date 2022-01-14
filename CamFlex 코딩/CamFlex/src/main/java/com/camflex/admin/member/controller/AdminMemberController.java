package com.camflex.admin.member.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.member.service.AdminMemberService;
import com.camflex.common.vo.PageRequest;
import com.camflex.common.vo.Pagination;
import com.camflex.common.vo.CodeLabelValue;


@Controller
@RequestMapping(value = "/admin/member")
public class AdminMemberController {

	private Logger log = LoggerFactory.getLogger(AdminMemberController.class);

	private HttpSession session;
	private String m_id;
	
	@Autowired
	private AdminMemberService adminMemberService;

	/*******************************
	 * 회원 리스트 구현하기
	 *******************************/
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	public String memberList(@ModelAttribute("pgrq") PageRequest pageRequest, Model model, HttpServletRequest request, HttpServletResponse response)throws Exception {
		sessionCheck(request, response, "로그인 후 이용 가능합니다.");
		log.info("회원 리스트 호출 성공");
		// 뷰에 페이징 처리를 한 게시글 목록을 전달한다.
		model.addAttribute("memberList", adminMemberService.memberList(pageRequest));
		model.addAttribute("id", m_id);
		
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
		searchTypeCodeValueList.add(new CodeLabelValue("d", "신규가입"));		
		searchTypeCodeValueList.add(new CodeLabelValue("p", "전화번호"));
		model.addAttribute("searchTypeCodeValueList", searchTypeCodeValueList);
		
		return "admin/member/memberList";
	}
	
	/****************************
	 * 로그인 체크
	 ***************************/
	private void sessionCheck(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		session = request.getSession();
		m_id = (String) session.getAttribute("m_id");
		log.info("m_id : " + m_id);
		
		if(m_id == null) {
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('" + message + "');");
			out.println("location.href='/admin/login/login'");
			out.println("</script>");
			out.flush();
		}
	}


}
