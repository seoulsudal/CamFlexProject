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
	private int c_agree;
	private int p_u_agree;
	private int p_i_agree;
	private int a_agree;
	private Date r_updDate;
	private String r_cancel;
	private int rv_number;

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

	public Date getR_updDate() {
		return r_updDate;
	}

	public void setR_updDate(Date r_updDate) {
		this.r_updDate = r_updDate;
	}

	public String getR_cancel() {
		return r_cancel;
	}

	public void setR_cancel(String r_cancel) {
		this.r_cancel = r_cancel;
	}

	public int getRv_number() {
		return rv_number;
	}

	public void setRv_number(int rv_number) {
		this.rv_number = rv_number;
	}

}
