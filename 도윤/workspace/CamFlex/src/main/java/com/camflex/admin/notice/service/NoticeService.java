package com.camflex.admin.notice.service;

import java.util.List;

import com.camflex.admin.notice.vo.NoticeVO;

public interface NoticeService {

	// 전체 리스트 
	public List<NoticeVO> noticeList(NoticeVO nvo);

	
}
