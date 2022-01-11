package com.camflex.client.notice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.client.notice.dao.NoticeDAO;
import com.camflex.common.vo.PageRequest;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	// 공지사항 조회
	/*
	 * @Override public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws
	 * Exception {
	 * 
	 * List<AdminNoticeVO> list = new ArrayList<AdminNoticeVO>(); list =
	 * noticeDAO.noticeList(nvo); return list; }
	 */

	// 상세 페이지
	@Override
	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) throws Exception {
		AdminNoticeVO detail = null;
		detail = noticeDAO.noticeDetail(nvo);
		
		return detail;
	}

	@Override
	public List<AdminNoticeVO> noticeList(PageRequest pageRequest) throws Exception {
		return noticeDAO.noticeList(pageRequest);
	}

	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return noticeDAO.count(pageRequest);
	}
	
}
