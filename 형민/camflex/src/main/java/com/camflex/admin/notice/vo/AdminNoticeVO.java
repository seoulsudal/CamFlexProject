package com.camflex.admin.notice.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdminNoticeVO {

	private int n_number;		// 공지사항 게시글 번호
	private String n_title;		// 공지사항 글제목
	private String n_content;	// 공지사항 글내용
	
	private MultipartFile file;	// 공지사항 사진
	private String n_photo;		// 공지사항 사진 파일 경로명
	
	private Date n_date;		// 공지사항 작성일
	private String n_writer;	// 공지사항 작성자
	
	public AdminNoticeVO() {
		super();
	}

	public AdminNoticeVO(int n_number, String n_title, String n_content, Date n_date, String n_writer) {
		super();
		this.n_number = n_number;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_date = n_date;
		this.n_writer = n_writer;
	}
	
	
	public AdminNoticeVO(int n_number, String n_title, String n_content, MultipartFile file, String n_photo, Date n_date,
			String n_writer) {
		super();
		this.n_number = n_number;
		this.n_title = n_title;
		this.n_content = n_content;
		this.file = file;
		this.n_photo = n_photo;
		this.n_date = n_date;
		this.n_writer = n_writer;
	}

	public int getN_number() {
		return n_number;
	}

	public void setN_number(int n_number) {
		this.n_number = n_number;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getN_photo() {
		return n_photo;
	}

	public void setN_photo(String n_photo) {
		this.n_photo = n_photo;
	}

	public Date getN_date() {
		return n_date;
	}

	public void setN_date(Date n_date) {
		this.n_date = n_date;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}
	
	
}