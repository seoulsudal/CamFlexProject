package com.camflex.admin.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.reservation.dao.AdminReservationDAO;
import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class AdminReservationServiceImpl implements AdminReservationService {

	
	@Autowired
	private AdminReservationDAO adminReservationDAO;

	// 예약 리스트
	@Override
	public List<ReservationVO> reservationList(PageRequest pageRequest) {
		
		return adminReservationDAO.reservationList(pageRequest);
	}

	// 예약 전체 수를 반환
	@Override
	public int count(PageRequest pageRequest) {
		
		return adminReservationDAO.count(pageRequest);
	}

	// 신규 예약 리스트
	@Override
	public List<ReservationVO> newRsvList(PageRequest pageRequest) {
		
		return adminReservationDAO.newRsvList(pageRequest);
	}
	
}
