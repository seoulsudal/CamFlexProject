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

	// 신규 예약 리스트
	@Override
	public List<ReservationVO> newRsvList(PageRequest pageRequest) {
		
		return adminReservationDAO.newRsvList(pageRequest);
	}

	
	  @Override public int confirmRsv(ReservationVO rvo) {
	  
	  int result = 0; 
	  try { 
		  return adminReservationDAO.confirmRsv(rvo);
	  }catch(Exception e) { e.printStackTrace(); result = 0; }
	  
	  return result;
	  
	  }

	// 예약 취소 리스트
	@Override
	public List<ReservationVO> cancelList(PageRequest pageRequest) {
		
		return adminReservationDAO.cancelList(pageRequest);
	}

	// 예약 전체 수를 반환
	@Override		
	public int count(PageRequest pageRequest) {
			
		return adminReservationDAO.count(pageRequest);
	}
	
	@Override
	public int count1(PageRequest pageRequest) {
		
		return adminReservationDAO.count1(pageRequest);
	}

	@Override
	public int count2(PageRequest pageRequest) {
		
		return adminReservationDAO.count2(pageRequest);
	}


	
	// 예약 취소 구현
	@Override
	public int cancelRsv(ReservationVO rvo) {
		
		int result = 0;
		try {
			result = adminReservationDAO.cancelRsv(rvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	 
	
	
}
