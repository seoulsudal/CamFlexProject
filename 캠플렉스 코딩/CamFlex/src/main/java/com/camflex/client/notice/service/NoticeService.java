package com.camflex.client.notice.service;

import java.util.List;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.common.vo.PageRequest;

public interface NoticeService {

	/* public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws Exception; */

	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) throws Exception;

	public List<AdminNoticeVO> noticeList(PageRequest pageRequest) throws Exception;

	public int count(PageRequest pageRequest) throws Exception;

}
