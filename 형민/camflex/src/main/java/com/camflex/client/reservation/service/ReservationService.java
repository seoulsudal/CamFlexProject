package com.camflex.client.reservation.service;

import java.util.List;

import com.camflex.client.reservation.vo.ReservationVO;

public interface ReservationService {

	// 실시간 예약 생성
	public int register(ReservationVO rvo) throws Exception;

	// 예약 조회
	public List<ReservationVO> reservationList(ReservationVO rvo) throws Exception;

}
