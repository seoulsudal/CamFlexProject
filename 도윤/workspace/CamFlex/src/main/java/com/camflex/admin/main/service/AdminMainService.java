package com.camflex.admin.main.service;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;

public interface AdminMainService {

	// 오늘 날짜 기준 가입한 회원 수 출력
	public List<LoginVO> mainList(LoginVO lvo);

}
