package com.camflex.admin.main.dao;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;
import com.camflex.client.reservation.vo.ReservationVO;

public interface AdminMainDAO {

	// 오늘 날짜 기준 가입한 회원 수 출력
	public List<LoginVO> mainList(LoginVO lvo);

	// 신규 예약 대기
	public List<ReservationVO> rsvList(ReservationVO rvo);

	// 오늘 날짜 방문 고객
	public List<ReservationVO> visit(ReservationVO rvo);

}
