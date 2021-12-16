package com.camflex.admin.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camflex.admin.notice.dao.AdminNoticeDAO;
import com.camflex.admin.notice.vo.NoticeVO;



@Service
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {

	@Autowired
	private AdminNoticeDAO adminNoticeDAO;
	
	// 글 전체 조회
	@Override
	public List<NoticeVO> noticeList(NoticeVO nvo) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		list = adminNoticeDAO.noticeList(nvo);
		return list;
	}

	// 글 등록
	@Override
	public int regNotice(NoticeVO nvo) {
		int result = 0;
		try {
			result = adminNoticeDAO.regNotice(nvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	// 글 상세페이지
	@Override
	public NoticeVO noticeDetail(NoticeVO nvo) {
		NoticeVO detail = null;
		detail = adminNoticeDAO.noticeDetail(nvo);
		return detail;
	}

	// 글 수정
	@Override
	public int updateNotice(NoticeVO nvo) {
		int result = 0;
		try {
			result = adminNoticeDAO.updateNotice(nvo);
		}catch(Exception e) {
			e.printStackTrace();
			result = 0;
		}
		
		return result;
	}

}
