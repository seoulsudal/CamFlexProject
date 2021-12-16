package com.camflex.admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.camflex.admin.notice.service.AdminNoticeService;
import com.camflex.admin.notice.vo.NoticeVO;
import com.camflex.common.file.FileUploadUtil;

@Controller
@RequestMapping(value = "/admin/notice")
public class AdminNoticeController {

	private Logger log = LoggerFactory.getLogger(AdminNoticeController.class);
	
	@Autowired
	private AdminNoticeService adminNoticeService;
	
	/*****************************************
	 * 공지사항 기본 조회
	 *****************************************/
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)
	public String noticeList(@ModelAttribute NoticeVO nvo, Model model) {
		log.info("공지사항 목록 호출 성공");
		
		List<NoticeVO> noticeList = adminNoticeService.noticeList(nvo);
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("data", nvo);
		
		return "admin/notice/noticeList";
	}
	
	/****************************************
	 * 공지사항 등록 폼 출력
	 ****************************************/
	@RequestMapping(value = "/regNotice", method = RequestMethod.GET)
	public String regForm(HttpSession session) {
		log.info("글 등록 폼 호출 성공");
		return "admin/notice/regNotice";
	}
	
	/****************************************
	 * 글 등록 구현
	 ****************************************/
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String regNotice(@ModelAttribute NoticeVO nvo, Model model, HttpServletRequest request)throws IllegalStateException, IOException{
		log.info("글 등록 호출");
		
		int result = 0;
		String url = "";
		
		if(nvo.getFile() != null) {
			String n_photo = FileUploadUtil.fileUpload(nvo.getFile(), request, "notice");
			nvo.setN_photo(n_photo);
		}
		result = adminNoticeService.regNotice(nvo);
		if(result == 1) {
			url = "/admin/notice/noticeList";
		}else {
			model.addAttribute("code", 1);
			url = "/admin/notice/regNotice";
		}
		return "redirect:" + url;
	}
	
	/************************************
	 * 글 상세 페이지
	 ***********************************/
	@RequestMapping(value = "/noticeDetail", method = RequestMethod.GET)
	public String noticeDetail(@ModelAttribute NoticeVO nvo, Model model) {
		log.info("글 상세 페이지 호출 성공");
		log.info("글 번호 : " + nvo.getN_number());
		
		NoticeVO detail = new NoticeVO();
		
		detail = adminNoticeService.noticeDetail(nvo);
		
		
		/*
		 * if(detail != null) { // 상세 페이지에서 textarea 부분에 공백부분을 \n, <br>를 표기하는 방법
		 * 
		 * detail.setN_content(detail.getN_content().toString().replaceAll("\n",
		 * "<br>"));
		 * 
		 * }
		 */
		
		model.addAttribute("detail", detail);
		
		return "admin/notice/noticeDetail";
	}
	
	/****************************************
	 * 상품 수정 폼
	 ****************************************/
	@RequestMapping(value = "/updateNotice", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute NoticeVO nvo, Model model) {
		log.info("글 수정 폼 호출 성공");
		log.info("글 번호 : " + nvo.getN_number());
		
		NoticeVO update = new NoticeVO();
		update = adminNoticeService.noticeDetail(nvo);
		
		model.addAttribute("update", update);
		
		return "admin/notice/updateNotice";
	}
	
	/*********************************
	 * 글 수정 구현
	 *********************************/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateNotice(@ModelAttribute NoticeVO nvo, HttpServletRequest request)throws IllegalStateException, IOException{
		log.info("글 수정 성공");
		
		int result = 0;
		String url = "";
		String n_photo = "";
		
		if(!nvo.getFile().isEmpty()) {
			log.info("======== file = " + nvo.getFile().getOriginalFilename());
			if(!nvo.getN_photo().isEmpty()) {
				FileUploadUtil.fileDelete(nvo.getN_photo(), request);
			}
			n_photo = FileUploadUtil.fileUpload(nvo.getFile(), request, "notice");
			nvo.setN_photo(n_photo);
		}
		else {
			log.info("첨부 파일 없음");
			nvo.setN_photo("");
		}
		log.info("========n_photo = " + nvo.getN_photo());
		result = adminNoticeService.updateNotice(nvo);
		
		if(result == 1) {
			url = "/admin/notice/noticeDetail?n_number=" + nvo.getN_number();
		}
		return "redirect:" + url;
		
	}
}
