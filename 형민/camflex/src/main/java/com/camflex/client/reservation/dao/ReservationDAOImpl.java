package com.camflex.client.reservation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.reservation.vo.ReservationVO;

@Repository
public class ReservationDAOImpl implements ReservationDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.client.reservation.dao.ReservationDAO";

	// 실시간 예약 생성
	@Override
	public int create(ReservationVO rvo) throws Exception {
		return sqlSession.insert("reservationRegister", rvo);
	}

	// 예약 조회
	@Override
	public List<ReservationVO> reservationList(ReservationVO rvo) throws Exception {
		return sqlSession.selectList(namespace + ".reservationList", rvo);
	}
	
}
