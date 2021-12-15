package com.camflex.admin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.product.dao.AdminProductDAO;
import com.camflex.admin.product.vo.AdminProductVO;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {

	@Autowired
	private AdminProductDAO adminProductDAO;

	// 상품 전체 조회
	@Override
	public List<AdminProductVO> productList(AdminProductVO pvo) {

		List<AdminProductVO> list = new ArrayList<AdminProductVO>();
		System.out.println("서비스 1");
		list = adminProductDAO.productList(pvo);
		System.out.println("서비스 2");
		return list;
	}

	// 상품 등록
	@Override
	public int regProduct(AdminProductVO pvo) {
		int result = 0;
		try {
			result = adminProductDAO.regProduct(pvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 상품 상세
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
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}

		return result;
	}

}
