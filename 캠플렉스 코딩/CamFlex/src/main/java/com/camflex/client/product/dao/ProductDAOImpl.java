package com.camflex.client.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.product.vo.AdminProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired 
	private SqlSession session;
	
	private static final String namespace = "com.camflex.client.product.dao.ProductDAO";

	// 캠핑장 리스트
	@Override
	public List<AdminProductVO> productList(AdminProductVO pvo) {
		return session.selectList(namespace + ".productList", pvo);
	}

	// 상세 페이지
	@Override
	public AdminProductVO productDetail(AdminProductVO pvo) {
		return (AdminProductVO)session.selectOne("productDetail", pvo);
	}	 
	
}
