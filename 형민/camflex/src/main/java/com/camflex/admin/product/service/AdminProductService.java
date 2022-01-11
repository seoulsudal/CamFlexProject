package com.camflex.admin.product.service;

import java.util.List;

import com.camflex.admin.product.vo.AdminProductVO;
import com.camflex.common.vo.PageRequest;

public interface AdminProductService {

	// 전체 리스트 조회
	public List<AdminProductVO> productList(PageRequest pageRequest);

	// 상품 등록
	public int regProduct(AdminProductVO pvo);

	// 상품 상세 페이지
	public AdminProductVO productDetail(AdminProductVO pvo);

	// 상품 수정
	public int updateProduct(AdminProductVO pvo);
	
	// 상품 전체 수를 반환
	public int count(PageRequest pageRequest);

}
