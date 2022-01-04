package com.camflex.client.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.client.review.dao.ReviewDAO;
import com.camflex.client.review.vo.ReviewVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewDAO reviewDAO;

	// 댓글 목록 구현
	@Override
	public List<ReviewVO> reviewList(int p_number) throws Exception {
		return reviewDAO.reviewList(p_number);
	}

	// 댓글 글쓰기 구현
	@Override
	public int reviewInsert(ReviewVO rvvo) throws Exception {
		int result = 0;
		
		try {
			result = reviewDAO.reviewInsert(rvvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
	// 카운트
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return reviewDAO.count(pageRequest);
	}

	@Override
	public Integer rv_count(Integer r_number) throws Exception {
		return reviewDAO.rv_count(r_number);
	}

	
}
