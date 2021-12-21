package com.camflex.admin.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.login.vo.LoginVO;

@Repository
public class AdminMainDAOImpl implements AdminMainDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 오늘 날짜 기준 가입한 회원 수 출력
	@Override
	public List<LoginVO> mainList(LoginVO lvo) {
		
		return sqlSession.selectList("com.camflex.admin.main.dao.AdminMainDAO.mainList", lvo);
	}

}
