package com.camflex.client.login.dao;

import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public interface LoginDAO {

	// 회원가입 처리
	public void insert(LoginVO vo) throws Exception;


}
