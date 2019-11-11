package com.pc.parts.dto;

import java.util.Date;

public class NotiCmtDTO {
	private int idx;
	private int noti_idx;
	private String cmt_comp;
	private String cmt_content;
	private Date date;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getNoti_idx() {
		return noti_idx;
	}
	public void setNoti_idx(int noti_idx) {
		this.noti_idx = noti_idx;
	}
	public String getCmt_comp() {
		return cmt_comp;
	}
	public void setCmt_comp(String cmt_comp) {
		this.cmt_comp = cmt_comp;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
