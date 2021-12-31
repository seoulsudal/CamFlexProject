package com.camflex.admin.notice.service;

import java.util.List;

import com.camflex.admin.notice.vo.NoticeVO;
import com.camflex.common.vo.PageRequest;

public interface AdminNoticeService {

	// 기본 조회
	public List<NoticeVO> noticeList(PageRequest pageRequest);

	// 글 등록
	public int regNotice(NoticeVO nvo);

	// 글 상세 페이지
	public NoticeVO noticeDetail(NoticeVO nvo);

	// 글 수정
	public int updateNotice(NoticeVO nvo);

	// 공지사항 글 전체 수 반환
	public int count(PageRequest pageRequest);
}
