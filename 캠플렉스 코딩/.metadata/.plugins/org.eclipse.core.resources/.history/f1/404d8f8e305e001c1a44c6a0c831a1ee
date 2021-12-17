package com.camflex.client.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.product.vo.AdminProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired private SqlSession session;

	// 캠핑장 리스트
	@Override
	public List<AdminProductVO> productList() throws Exception {
		return session.selectList("productList");
	}
	 
	
}
