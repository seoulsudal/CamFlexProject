package com.camflex.admin.member.dao;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

public interface AdminMemberDAO {

	// 회원 리스트
	public List<MemberVO> memberList(PageRequest pageRequest);

	// 회원 전체 수를 반환한다.
	public int count(PageRequest pageRequest);

}
