package com.camflex.admin.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camflex.admin.product.vo.AdminProductVO;

import jdk.internal.org.jline.utils.Log;

@Repository
public class AdminProductDAOImpl implements AdminProductDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String namespace = "com.camflex.admin.product.dao.AdminProductDAO";

	@Override
	public List<AdminProductVO> productList(AdminProductVO pvo) {
		return sqlSession.selectList(namespace + ".productList", pvo);
	}

	@Override
	public int regProduct(AdminProductVO pvo) {

		return sqlSession.insert(namespace + ".regProduct", pvo);
	}

	@Override
	public AdminProductVO productDetail(AdminProductVO pvo) {

		return (AdminProductVO) sqlSession.selectOne(namespace + ".productDetail", pvo);
	}

	@Override
	public int updateProduct(AdminProductVO pvo) {

		return sqlSession.update(namespace + ".updateProduct", pvo);
	}

}
