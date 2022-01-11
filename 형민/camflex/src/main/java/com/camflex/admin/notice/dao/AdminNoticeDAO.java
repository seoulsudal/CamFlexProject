package com.camflex.admin.notice.dao;

import java.util.List;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.common.vo.PageRequest;

public interface AdminNoticeDAO {

	// 글 전체 조회
	public List<AdminNoticeVO> noticeList(PageRequest pageRequest);

	// 글 등록
	public int regNotice(AdminNoticeVO nvo);

	// 글 상세 페이지
	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo);

	// 글 수정
	public int updateNotice(AdminNoticeVO nvo);
	
	// 글 전체 수 반환
	public int count(PageRequest pageRequest);
}
