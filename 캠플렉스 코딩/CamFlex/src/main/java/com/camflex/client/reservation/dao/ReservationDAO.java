package com.camflex.client.reservation.dao;

import java.util.List;

import com.camflex.client.reservation.vo.ReservationVO;

public interface ReservationDAO {

	public int create(ReservationVO rvo) throws Exception;

	public List<ReservationVO> reservationList(ReservationVO rvo) throws Exception;

}
