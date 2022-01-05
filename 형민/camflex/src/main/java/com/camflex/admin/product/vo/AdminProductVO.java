package com.camflex.admin.product.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class AdminProductVO {

	private int p_number = 0; // 상품번호
	private String p_type = ""; // 상품구분(유형)
	private String p_name = ""; // 상품명
	private int p_price = 0; // 상품가격
	private String p_information = ""; // 상품안내
	// 파일 업로드를 위한 속성
	private MultipartFile file; // 첨부파일
	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;
	private String p_mainphoto = ""; // 실제 서버에 저장한 파일명(상세페이지에서 메인으로 보일 사진)
	private String p_photo1 = ""; // 실제 서버에 저장한 파일명
	private String p_photo2 = ""; // 실제 서버에 저장한 파일명
	private String p_photo3 = ""; // 실제 서버에 저장한 파일명
	private Date p_date; // 상품 등록일

	public AdminProductVO() {
		super();
	}

	public AdminProductVO(int p_number, String p_type, String p_name, int p_price, String p_information, String p_mainphoto,
			String p_photo1, String p_photo2, String p_photo3) {
		this.p_number = p_number;
		this.p_type = p_type;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_information = p_information;
		this.p_mainphoto = p_mainphoto;
		this.p_photo1 = p_photo1;
		this.p_photo2 = p_photo2;
		this.p_photo3 = p_photo3;

	}

	public AdminProductVO(int p_number, String p_type, String p_name, int p_price, String p_information, String p_mainphoto,
			String p_photo1, String p_photo2, String p_photo3, Date p_date) {
		super();
		this.p_number = p_number;
		this.p_type = p_type;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_information = p_information;
		this.p_mainphoto = p_mainphoto;
		this.p_photo1 = p_photo1;
		this.p_photo2 = p_photo2;
		this.p_photo3 = p_photo3;
		this.p_date = p_date;
	}

	public int getP_number() {
		return p_number;
	}

	public void setP_number(int p_number) {
		this.p_number = p_number;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_information() {
		return p_information;
	}

	public void setP_information(String p_information) {
		this.p_information = p_information;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getP_mainphoto() {
		return p_mainphoto;
	}

	public void setP_mainphoto(String p_mainphoto) {
		this.p_mainphoto = p_mainphoto;
	}

	public String getP_photo1() {
		return p_photo1;
	}

	public void setP_photo1(String p_photo1) {
		this.p_photo1 = p_photo1;
	}

	public String getP_photo2() {
		return p_photo2;
	}

	public void setP_photo2(String p_photo2) {
		this.p_photo2 = p_photo2;
	}

	public String getP_photo3() {
		return p_photo3;
	}

	public void setP_photo3(String p_photo3) {
		this.p_photo3 = p_photo3;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

}
