package com.camflex.client.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.member.dao.MemberDAO;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	// 예약 취소 리스트 구현
	@Override
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception {
		return memberDAO.cancelList(pageRequest);
	}

	// 카운트
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return memberDAO.count(pageRequest);
	}

	// 지난 예약 리스트 구현
	@Override
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception {
		return memberDAO.pastList(pageRequest);
	}
	
	
}
