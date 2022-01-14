package com.camflex.client.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.client.review.vo.ReviewVO;
import com.camflex.common.vo.PageRequest;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

	@Autowired
	private SqlSession sqlSession;

	// 댓글 목록 구현
	@Override
	public List<ReviewVO> reviewList(int p_number) throws Exception {
		return sqlSession.selectList("reviewList", p_number);
	}

	// 댓글 글쓰기 처리
	@Override
	public int reviewInsert(ReviewVO rvvo) throws Exception {
		return sqlSession.insert("reviewInsert", rvvo);
	}

	// 카운트
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return sqlSession.selectOne("count");
	}

	@Override
	public Integer rv_count(Integer r_number) throws Exception {
		return sqlSession.selectOne("rv_count", r_number);
	}

}
