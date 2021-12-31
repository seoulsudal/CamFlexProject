package com.camflex.client.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

//DB 연결 구현
@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.client.member.dao.MemberDAO";

	// 회원가입 처리
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		sqlSession.insert(namespace + ".insertMember", vo);
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

	//비밀번호 체크
	@Override
	public MemberVO PwCheck(MemberVO vo) throws Exception {
		return sqlSession.selectOne(namespace + ".PwCheck", vo);
	}

	// 내 예약 리스트
	@Override
	public List<ReservationVO> ReserveList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList(namespace+ ".ReserveList", pageRequest);
	}
	
	// 페이징 카운트
	@Override
	public int count(PageRequest pageRequest) {
		return sqlSession.selectOne("count");
	}

}
