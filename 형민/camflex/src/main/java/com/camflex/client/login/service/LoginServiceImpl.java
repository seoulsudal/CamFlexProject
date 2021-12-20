package com.camflex.client.login.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.login.dao.LoginDAO;
import com.camflex.client.login.vo.LoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Inject
	private LoginDAO loginDAO;

	// 회원가입 처리
	@Override
	public void insertMember(LoginVO vo) throws Exception {
		loginDAO.insert(vo);
	}

	
}
