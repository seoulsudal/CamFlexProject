package com.camflex.admin.member.service;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;

public interface AdminMemberService {

	// 회원 리스트
	public List<LoginVO> memberList(LoginVO lvo);

}
