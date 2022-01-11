package com.camflex.admin.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class AdminReservationDAOImpl implements AdminReservationDAO {

	@Autowired
	private SqlSession sqlSession;

	// 예약 리스트
	@Override
	public List<ReservationVO> reservationList(PageRequest pageRequest) {
		
		return sqlSession.selectList("reservationList");
	}



	// 신규 예약 리스트
	@Override
	public List<ReservationVO> newRsvList(PageRequest pageRequest) {
		
		return sqlSession.selectList("newRsvList");
	}
	// 예약 승인 처리
	  @Override public int confirmRsv(ReservationVO rvo) {
	  
	  return sqlSession.update("confirmRsv", rvo);
	 }

	// 예약 취소 리스트
	@Override
	public List<ReservationVO> cancelList(PageRequest pageRequest) {
		
		return sqlSession.selectList("cancelList");
	}

	// 예약 전체 수를 반환
	@Override
	public int count(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count");
	}	
	
	@Override
	public int count1(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count1");
	}

	@Override
	public int count2(PageRequest pageRequest) {
		
		return sqlSession.selectOne("count2");
	}

	// 예약 취소
	@Override
	public int cancelRsv(ReservationVO rvo) {
		
		return sqlSession.update("cancelRsv", rvo);
	}
	 


}
