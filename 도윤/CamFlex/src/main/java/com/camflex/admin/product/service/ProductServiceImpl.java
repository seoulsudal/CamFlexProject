package com.camflex.admin.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.product.dao.ProductDAO;
import com.camflex.admin.product.vo.ProductVO;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	// 상품 전체 조회
	@Override
	public List<ProductVO> productList(ProductVO pvo) {
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		System.out.println("서비스 1");
		list = productDAO.productList(pvo);
		System.out.println("서비스 2");
		return list;
	}
	// 상품 등록
	@Override
	public int regProduct(ProductVO pvo) {
		int result = 0;
		try {
			result = productDAO.regProduct(pvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 상품 상세
	@Override
	public ProductVO productDetail(ProductVO pvo) {
		ProductVO detail = null;
		detail = productDAO.productDetail(pvo);
		return detail;
	}

}
