package com.camflex.client.member.vo;

import java.util.Date;

public class MemberVO {

	private String m_id = "";// 아이디
	private String m_pw = "";// 비밀번호
	private String m_name = "";// 회원 이름
	private String m_birth;// 회원 생년 월일
	private String m_phone = "";// 회원 전화번호
	private Integer m_number; // 회원 번호
	private Date m_date; // 회원 가입날짜

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public void setM_number(Integer m_number) {
		this.m_number = m_number;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public Date getM_date() {
		return m_date;
	}

	public void setM_date(Date m_date) {
		this.m_date = m_date;
	}

}
