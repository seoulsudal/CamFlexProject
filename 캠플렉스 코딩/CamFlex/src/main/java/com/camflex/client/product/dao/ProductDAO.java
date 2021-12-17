package com.camflex.client.product.dao;

import java.util.List;

import com.camflex.admin.product.vo.AdminProductVO;

public interface ProductDAO {

	// 캠핑장 리스트
	public List<AdminProductVO> productList(AdminProductVO pvo);

	// 상세 페이지
	public AdminProductVO productDetail(AdminProductVO pvo);

}
