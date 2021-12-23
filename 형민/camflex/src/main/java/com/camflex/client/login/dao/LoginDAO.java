package com.camflex.client.login.dao;

import com.camflex.client.login.vo.LoginVO;

public interface LoginDAO {

	// 로그인 처리(사용자 ID에 해당하는 정보 가져오기)
	public LoginVO userIdSelect(String m_id);

	// 로그인 처리(ID, PW정보에 해당하는 사용자 정보
	public LoginVO loginSelect(String m_id, String m_pw) throws Exception;

}
