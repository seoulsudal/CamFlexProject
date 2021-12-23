package com.camflex.admin.main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.main.dao.AdminMainDAO;
import com.camflex.client.login.vo.LoginVO;

@Service
@Transactional
public class AdminMainServiceImpl implements AdminMainService {

	@Autowired
	private AdminMainDAO adminMainDAO;
	
	// 오늘 날짜 기준 가입한 회원 수 출력
	@Override
	public List<LoginVO> mainList(LoginVO lvo) {
		List<LoginVO> list = new ArrayList<LoginVO>();
		list = adminMainDAO.mainList(lvo);
		return list;
	}

}
