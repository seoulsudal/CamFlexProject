package com.camflex.admin.reservation.dao;

import java.util.List;

import com.camflex.client.reservation.vo.ReservationVO;
import com.camflex.common.vo.PageRequest;

public interface AdminReservationDAO {

	// 예약 리스트
	public List<ReservationVO> reservationList(PageRequest pageRequest);

	// 신규 예약 리스트
	public List<ReservationVO> newRsvList(PageRequest pageRequest);
	// 예약 승인 처리
	public int confirmRsv(ReservationVO rvo);
	// 예약 취소 리스트
	public List<ReservationVO> cancelList(PageRequest pageRequest);
	
	// 예약 전체 수를 반환
	public int count(PageRequest pageRequest);	
	
	public int count1(PageRequest pageRequest);
	
	public int count2(PageRequest pageRequest);

	// 예약 취소
	public int cancelRsv(ReservationVO rvo);



}
