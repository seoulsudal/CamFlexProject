package com.camflex.admin.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.product.vo.ProductVO;

import jdk.internal.org.jline.utils.Log;


@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.camflex.admin.product.dao.ProductDAO";
	
	@Override
	public List<ProductVO> productList(ProductVO pvo) {
		System.out.println("dao 1");
		return sqlSession.selectList(namespace + ".productList", pvo);
	}

	@Override
	public int regProduct(ProductVO pvo) {
		
		return sqlSession.insert(namespace + ".regProduct", pvo);
	}

	@Override
	public ProductVO productDetail(ProductVO pvo) {
		
		return (ProductVO)sqlSession.selectOne(namespace + ".productDetail", pvo);
	}

}
