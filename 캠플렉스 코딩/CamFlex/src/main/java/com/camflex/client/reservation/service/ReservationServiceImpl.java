package com.camflex.client.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.reservation.dao.ReservationDAO;
import com.camflex.client.reservation.vo.ReservationVO;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDAO reservationDAO;

	// 실시간 예약 생성
	@Override
	public int register(ReservationVO rvo) throws Exception {		
		int result = 0;
		
		try {
			result = reservationDAO.create(rvo);
		} catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	} 
	
}
