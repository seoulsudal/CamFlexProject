package com.camflex.client.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.member.dao.MemberDAO";

	// 회원가입 처리
	@Override
	public int insertMember(MemberVO mvo) throws Exception {
		return sqlSession.insert(namespace + ".insertMember", mvo);
	}

	// 내 정보 보기, 정보 수정 폼
	@Override
	public MemberVO readMember(String m_id) throws Exception {
		MemberVO vo = sqlSession.selectOne(namespace + ".readMember", m_id);
		return vo;
	}

	// 내 정보 수정 처리
	@Override
	public int MemberModify(MemberVO vo) throws Exception {
		return sqlSession.update(namespace + ".MemberModify", vo);
	}

	// 비밀번호 체크
	@Override
	public MemberVO PwCheck(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".PwCheck", vo);
	}

	// 내 예약 리스트
	@Override
	public List<MemberVO> reserveList(PageRequest pageRequest) throws Exception {
		List<MemberVO> vo = sqlSession.selectList("reserveList");
		return vo;
	}

	// 예약 취소 폼
	@Override
	public ReservationVO reserveCancel(int r_number) throws Exception {
		return sqlSession.selectOne(namespace + ".reserveCancel", r_number);
	}

	// 예약 취소 처리
	@Override
	public int Cancel(ReservationVO vo) throws Exception {
		return sqlSession.update(namespace + ".Cancel", vo);
	}

	// 예약 취소 리스트 구현
	@Override
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList("cancelList");
	}

	// 카운트
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return sqlSession.selectOne("count");
	}

	// 지난 예약 리스트 구현
	@Override
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList("pastList");
	}

}
