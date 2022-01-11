package com.camflex.client.notice.dao;

import java.util.List;

import com.camflex.admin.notice.vo.AdminNoticeVO;
import com.camflex.common.vo.PageRequest;

public interface NoticeDAO {

	/* public List<AdminNoticeVO> noticeList(AdminNoticeVO nvo) throws Exception; */

	public AdminNoticeVO noticeDetail(AdminNoticeVO nvo) throws Exception;

	public List<AdminNoticeVO> noticeList(PageRequest pageRequest);

	public int count(PageRequest pageRequest);

}
