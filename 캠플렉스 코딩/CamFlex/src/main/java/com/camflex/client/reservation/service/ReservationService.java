package com.camflex.client.reservation.service;

import com.camflex.client.reservation.vo.ReservationVO;

public interface ReservationService {

	// 실시간 예약 생성
	public int register(ReservationVO rvo) throws Exception;

}
