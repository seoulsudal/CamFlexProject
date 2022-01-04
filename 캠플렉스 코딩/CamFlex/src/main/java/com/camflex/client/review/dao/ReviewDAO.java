package com.camflex.client.review.dao;

import java.util.List;

import com.camflex.client.review.vo.ReviewVO;
import com.camflex.common.vo.PageRequest;

public interface ReviewDAO {

	// 댓글 목록 구현
	public List<ReviewVO> reviewList(int p_number) throws Exception;

	// 댓글 글쓰기 처리
	public int reviewInsert(ReviewVO rvvo) throws Exception;
	
	// 카운트
	public int count(PageRequest pageRequest) throws Exception;

	public Integer rv_count(Integer r_number) throws Exception;

}
