package com.camflex.client.member.vo;

import java.util.Date;

public class MemberVO {
	private String m_id = "";// 아이디
	private String m_pw = "";// 비밀번호
	private String m_name = "";// 회원 이름
	private String m_phone = "";// 회원 전화번호
	private Date m_birth;// 회원 생년 월일
	private String b_name = "";// 상호명
	private int c_agree;// 취소 수수료 동의
	private int p_u_agree;// 유의사항 동의
	private int p_i_agree;// 이용약관 동의
	private int a_agree;// 성인 동의

	public MemberVO() {

	}

	public MemberVO(String m_id, String m_pw, String m_name, String m_phone, Date m_birth, String b_name, int c_agree,
			int p_u_agree, int p_i_agree, int a_agree) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_birth = m_birth;
		this.b_name = b_name;
		this.c_agree = c_agree;
		this.p_u_agree = p_u_agree;
		this.p_i_agree = p_i_agree;
		this.a_agree = a_agree;
	}

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

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public Date getM_birth() {
		return m_birth;
	}

	public void setM_birth(Date m_birth) {
		this.m_birth = m_birth;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getC_agree() {
		return c_agree;
	}

	public void setC_agree(int c_agree) {
		this.c_agree = c_agree;
	}

	public int getP_u_agree() {
		return p_u_agree;
	}

	public void setP_u_agree(int p_u_agree) {
		this.p_u_agree = p_u_agree;
	}

	public int getP_i_agree() {
		return p_i_agree;
	}

	public void setP_i_agree(int p_i_agree) {
		this.p_i_agree = p_i_agree;
	}

	public int getA_agree() {
		return a_agree;
	}

	public void setA_agree(int a_agree) {
		this.a_agree = a_agree;
	}

	@Override
	public String toString() {
		return "LoginVO [getM_id()=" + getM_id() + ", getM_pw()=" + getM_pw() + ", getM_name()=" + getM_name()
				+ ", getM_phone()=" + getM_phone() + ", getM_birth()=" + getM_birth() + ", getB_name()=" + getB_name()
				+ ", getC_agree()=" + getC_agree() + ", getP_u_agree()=" + getP_u_agree() + ", getP_i_agree()="
				+ getP_i_agree() + ", getA_agree()=" + getA_agree() + "]";
	}

}
