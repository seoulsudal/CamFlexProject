package com.camflex.admin.member.dao;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;

public interface AdminMemberDAO {

	// 회원 리스트
	public List<LoginVO> memberList(LoginVO lvo);

}
