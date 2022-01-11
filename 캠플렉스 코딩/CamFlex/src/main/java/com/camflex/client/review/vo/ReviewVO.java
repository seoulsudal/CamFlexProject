package com.camflex.client.review.vo;

import java.util.Date;

public class ReviewVO {

	private int rv_number;
	private String m_id;
	private int p_number;
	private Date rv_date;
	private String rv_content;
	private int r_number;
	private int rv_count;

	public int getRv_number() {
		return rv_number;
	}

	public void setRv_number(int rv_number) {
		this.rv_number = rv_number;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getP_number() {
		return p_number;
	}

	public void setP_number(int p_number) {
		this.p_number = p_number;
	}

	public Date getRv_date() {
		return rv_date;
	}

	public void setRv_date(Date rv_date) {
		this.rv_date = rv_date;
	}

	public String getRv_content() {
		return rv_content;
	}

	public void setRv_content(String rv_content) {
		this.rv_content = rv_content;
	}

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public int getRv_count() {
		return rv_count;
	}

	public void setRv_count(int rv_count) {
		this.rv_count = rv_count;
	}

}
