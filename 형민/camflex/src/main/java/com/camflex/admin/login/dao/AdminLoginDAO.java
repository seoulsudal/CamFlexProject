package com.camflex.admin.login.dao;

import com.camflex.client.login.vo.LoginVO;

public interface AdminLoginDAO {

	public LoginVO loginCheck(LoginVO vo)throws Exception;

}
