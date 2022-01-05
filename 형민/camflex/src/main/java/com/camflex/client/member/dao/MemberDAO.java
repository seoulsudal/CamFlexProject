package com.camflex.client.member.dao;

import java.util.List;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

//DB 연결 구현
public interface MemberDAO {

	// 회원가입 처리
	public void insertMember(MemberVO vo) throws Exception;

	// 내 정보 보기, 정보 수정 폼
	public MemberVO readMember(String m_id) throws Exception;

	// 내 정보 수정 처리
	public int MemberModify(MemberVO vo) throws Exception;

	// 내 예약 리스트 구현
	public List<MemberVO> reserveList(PageRequest pageRequest) throws Exception;

	// 비밀번호 체크
	public MemberVO PwCheck(MemberVO vo) throws Exception;

	// 예약 취소 폼
	public MemberVO reserveCancel(ReservationVO rvo) throws Exception;

	// 예약 취소 처리
	public int Cancel(ReservationVO vo) throws Exception;

	// 페이징 카운트
	public int count(PageRequest pageRequest);

}
