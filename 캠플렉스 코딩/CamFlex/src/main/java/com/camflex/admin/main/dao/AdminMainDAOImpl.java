package com.camflex.admin.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 오늘 날짜 기준 가입한 회원 수 출력
	@Override
	public List<MemberVO> mainList(MemberVO mvo) {
		
		return sqlSession.selectList("com.camflex.admin.main.dao.AdminMainDAO.mainList", mvo);
	}

	// 신규 예약 대기
	@Override
	public List<ReservationVO> rsvList(ReservationVO rvo) {
		
		return sqlSession.selectList("com.camflex.admin.main.dao.AdminMainDAO.rsvList", rvo);
	}

	// 오늘 날짜 방문 고객
	@Override
	public List<ReservationVO> visit(ReservationVO rvo) {
		
		return sqlSession.selectList("com.camflex.admin.main.dao.AdminMainDAO.visit", rvo);
	}

	// 전일 매출
	@Override
	public List<ReservationVO> yesterday(ReservationVO rvo) {
		
		return sqlSession.selectList("com.camflex.admin.main.dao.AdminMainDAO.yesterday", rvo);
	}

}
