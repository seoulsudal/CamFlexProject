package com.camflex.admin.notice.dao;

import java.util.List;

import com.camflex.admin.notice.vo.NoticeVO;

public interface NoticeDAO {

	// 전체 리스트 조회
	public List<NoticeVO> noticeList(NoticeVO nvo);

}
