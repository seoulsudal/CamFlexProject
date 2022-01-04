package com.camflex.admin.login.service;

import com.camflex.client.login.vo.LoginVO;

public interface AdminLoginService {

	public LoginVO loginCheck(LoginVO vo)throws Exception;

}
