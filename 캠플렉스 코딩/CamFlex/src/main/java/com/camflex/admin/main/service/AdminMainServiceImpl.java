package com.camflex.admin.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.main.dao.AdminMainDAO;
import com.camflex.client.member.vo.MemberVO;
import com.camflex.client.reservation.vo.ReservationVO;

@Service
@Transactional
public class AdminMainServiceImpl implements AdminMainService {

	@Autowired
	private AdminMainDAO adminMainDAO;
	
	// 오늘 날짜 기준 가입한 회원 수 출력
	@Override
	public List<MemberVO> mainList(MemberVO mvo) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = adminMainDAO.mainList(mvo);
		return list;
	}

	// 신규 예약 대기
	@Override
	public List<ReservationVO> rsvList(ReservationVO rvo) {
		
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		list = adminMainDAO.rsvList(rvo);
		return list;
	}

	// 오늘 날짜 방문 고객
	@Override
	public List<ReservationVO> visit(ReservationVO rvo) {
		
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		list = adminMainDAO.visit(rvo);
		return list;
	}

	// 전일 매출
	@Override
	public List<ReservationVO> yesterday(ReservationVO rvo) {
		
		List<ReservationVO> list = new ArrayList<ReservationVO>();
		list = adminMainDAO.yesterday(rvo);
		return list;
	}

}
