package com.camflex.client.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.member.vo.MemberVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	// 예약 취소 리스트 구현
	@Override
	public List<MemberVO> cancelList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList("cancelList");
	}

	// 카운트
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return sqlSession.selectOne("count");
	}

	// 지난 예약 리스트 구현
	@Override
	public List<MemberVO> pastList(PageRequest pageRequest) throws Exception {
		return sqlSession.selectList("pastList");
	}
	
}
