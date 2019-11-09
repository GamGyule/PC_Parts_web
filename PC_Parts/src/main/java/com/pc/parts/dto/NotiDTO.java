package com.pc.parts.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class NotiDTO {
	
	private int idx;
	private String from_co;
	private String to_co;
	private int pid;
	private int cnt;
	private int flag;
	private Date date;
	private String pd_name;
	
	SimpleDateFormat local_date = new SimpleDateFormat("yyyy-MM-dd HH-mm");
	
	
	public String getDate() {
		return local_date.format(date);
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFrom_co() {
		return from_co;
	}
	public void setFrom_co(String from_co) {
		this.from_co = from_co;
	}
	public String getTo_co() {
		return to_co;
	}
	public void setTo_co(String to_co) {
		this.to_co = to_co;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	
	
	
	

	
}
