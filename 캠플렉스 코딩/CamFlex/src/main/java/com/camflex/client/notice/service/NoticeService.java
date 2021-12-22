package com.camflex.client.notice.service;

import java.util.List;

import com.camflex.admin.notice.vo.AdminNoticeVO;

public interface NoticeService {

	public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws Exception;

	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) throws Exception;

}
