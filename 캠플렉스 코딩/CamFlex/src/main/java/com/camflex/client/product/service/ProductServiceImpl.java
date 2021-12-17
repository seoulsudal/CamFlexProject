package com.camflex.client.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.client.product.dao.ProductDAO;



@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	// 캠핑장 리스트
	@Override
	public List<AdminProductVO> productList(AdminProductVO pvo) {

		List<AdminProductVO> list = new ArrayList<AdminProductVO>();
		list = productDAO.productList(pvo);
		return list;
	}

	// 상세 페이지
	@Override
	public AdminProductVO productDetail(AdminProductVO pvo) {
		AdminProductVO detail = null;
		detail = productDAO.productDetail(pvo);
		
		return detail;
	}



}
