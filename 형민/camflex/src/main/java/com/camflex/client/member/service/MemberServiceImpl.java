package com.camflex.client.member.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.member.dao.MemberDAO;
import com.camflex.client.member.vo.MemberVO;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	// 회원가입 처리
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		memberDAO.insertMember(vo);
	}

}
