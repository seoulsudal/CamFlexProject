package com.camflex.client.reservation.vo;

import java.sql.Date;

public class ReservationVO {

	private int r_number;
	private String m_id;
	private int p_number;
	private Date r_apllicationDate;
	private Date r_startDate;
	private Date r_endDate;
	private int r_price;
	private String r_state;
	private int r_count;
	private int rv_number;
	private Date rv_date;
	private String rv_content;

	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
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

	public Date getR_apllicationDate() {
		return r_apllicationDate;
	}

	public void setR_apllicationDate(Date r_apllicationDate) {
		this.r_apllicationDate = r_apllicationDate;
	}

	public Date getR_startDate() {
		return r_startDate;
	}

	public void setR_startDate(Date r_startDate) {
		this.r_startDate = r_startDate;
	}

	public Date getR_endDate() {
		return r_endDate;
	}

	public void setR_endDate(Date r_endDate) {
		this.r_endDate = r_endDate;
	}

	public int getR_price() {
		return r_price;
	}

	public void setR_price(int r_price) {
		this.r_price = r_price;
	}

	public String getR_state() {
		return r_state;
	}

	public void setR_state(String r_state) {
		this.r_state = r_state;
	}

	public int getR_count() {
		return r_count;
	}

	public void setR_count(int r_count) {
		this.r_count = r_count;
	}

	public int getRv_number() {
		return rv_number;
	}

	public void setRv_number(int rv_number) {
		this.rv_number = rv_number;
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

}
