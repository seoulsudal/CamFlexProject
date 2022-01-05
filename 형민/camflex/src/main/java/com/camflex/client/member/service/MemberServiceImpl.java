package com.camflex.client.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.member.dao.MemberDAO;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

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

	// 내 정보 보기, 정보 수정 폼
	@Override
	public MemberVO readMember(String m_id) throws Exception {
		MemberVO vo = null;
		try {
			vo = memberDAO.readMember(m_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	// 내 정보 수정 처리
	@Override
	public MemberVO MemberModify(MemberVO vo) throws Exception {
		memberDAO.MemberModify(vo);
		return vo;
	}

	// 비밀번호 인증
	@Override
	public MemberVO PwCheck(MemberVO vo) throws Exception {
		return memberDAO.PwCheck(vo);
	}

	// 예약 리스트 조회
	@Override
	public List<MemberVO> reserveList(PageRequest pageRequest) throws Exception {
		return memberDAO.reserveList(pageRequest);
	}

	// 예약 취소 폼
	@Override
	public MemberVO reserveCancel(ReservationVO rvo) throws Exception {
		return memberDAO.reserveCancel(rvo);
	}

	// 예약 취소 처리
	@Override
	public int Cancel(ReservationVO vo) throws Exception {
		return memberDAO.Cancel(vo);
	}

	// 페이징 카운트
	@Override
	public int count(PageRequest pageRequest) {
		return memberDAO.count(pageRequest);
	}

}
