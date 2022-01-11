package com.camflex.client.inquiry.vo;

import java.util.Date;

public class InquiryVO {

	private int i_number;
	private String m_id;
	private String i_title;
	private String i_kinds;
	private Date i_date;
	private String i_content;
	private int level;
	private int parentNO;

	public int getI_number() {
		return i_number;
	}

	public void setI_number(int i_number) {
		this.i_number = i_number;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getI_title() {
		return i_title;
	}

	public void setI_title(String i_title) {
		this.i_title = i_title;
	}

	public String getI_kinds() {
		return i_kinds;
	}

	public void setI_kinds(String i_kinds) {
		this.i_kinds = i_kinds;
	}

	public Date getI_date() {
		return i_date;
	}

	public void setI_date(Date i_date) {
		this.i_date = i_date;
	}

	public String getI_content() {
		return i_content;
	}

	public void setI_content(String i_content) {
		this.i_content = i_content;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentNO() {
		return parentNO;
	}

	public void setParentNO(int parentNO) {
		this.parentNO = parentNO;
	}

}
