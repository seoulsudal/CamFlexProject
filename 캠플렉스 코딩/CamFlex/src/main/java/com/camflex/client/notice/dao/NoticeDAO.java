package com.camflex.client.notice.dao;

import java.util.List;

import com.camflex.admin.notice.vo.AdminNoticeVO;

public interface NoticeDAO {

	public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws Exception;

}
