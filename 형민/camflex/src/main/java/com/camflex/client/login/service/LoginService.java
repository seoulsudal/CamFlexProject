package com.camflex.client.login.service;

import java.util.List;

import com.camflex.client.login.vo.LoginVO;

public interface LoginService {

	// 회원가입 처리
	public void insertMember(LoginVO vo) throws Exception;

	
}
