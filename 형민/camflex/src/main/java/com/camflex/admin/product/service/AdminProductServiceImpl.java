package com.camflex.admin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.product.dao.AdminProductDAO;
import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.common.vo.PageRequest;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private AdminProductDAO adminProductDAO;
	
	// 전체 리스트 조회
	@Override
	public List<AdminProductVO> productList(PageRequest pageRequest) {

		return adminProductDAO.productList(pageRequest);
	}

	// 상품 등록
	@Override
	public int regProduct(AdminProductVO pvo) {
		int result = 0;
		try {
			result = adminProductDAO.regProduct(pvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 상품 상세 페이지
	@Override
	public AdminProductVO productDetail(AdminProductVO pvo) {
		AdminProductVO detail = null;
		detail = adminProductDAO.productDetail(pvo);
		return detail;
	}

	// 상품 수정
	@Override
	public int updateProduct(AdminProductVO pvo) {

		int result = 0;
		try {
			result = adminProductDAO.updateProduct(pvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}
	
	@Override
	public int count(PageRequest pageRequest) {
		
		return adminProductDAO.count(pageRequest);
	}

}
