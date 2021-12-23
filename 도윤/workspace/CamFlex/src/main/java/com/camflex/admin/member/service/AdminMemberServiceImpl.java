package com.camflex.admin.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.member.dao.AdminMemberDAO;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class AdminMemberServiceImpl implements AdminMemberService {
	
	@Autowired
	private AdminMemberDAO adminMemberDAO;

	// 회원 리스트
	@Override
	public List<MemberVO> memberList(PageRequest pageRequest) {
		
		
		
		return adminMemberDAO.memberList(pageRequest);
	}

	// 회원 전체 수를 반환한다.
	@Override
	public int count(PageRequest pageRequest) {
		
		return adminMemberDAO.count(pageRequest);
	}

}
