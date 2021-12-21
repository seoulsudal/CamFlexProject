package com.camflex.client.reservation.dao;

import com.camflex.client.reservation.vo.ReservationVO;

public interface ReservationDAO {

	public int create(ReservationVO rvo) throws Exception;

}
