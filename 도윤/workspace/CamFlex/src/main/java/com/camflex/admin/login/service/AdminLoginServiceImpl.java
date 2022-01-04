package com.camflex.admin.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.login.dao.AdminLoginDAO;
import com.camflex.client.login.vo.LoginVO;

@Service
@Transactional
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDAO adminLoginDAO;

	@Override
	public LoginVO loginCheck(LoginVO vo) throws Exception {

		return adminLoginDAO.loginCheck(vo);
	}
	
	
}
