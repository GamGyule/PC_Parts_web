package com.pc.parts.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartSupRequestDTO {

	private int pid;
	private String name;
	private String co;
	private int cnt;
	private Date date;
	private int price;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ChartSupRequestDTO [pid=" + pid + ", name=" + name + ", co=" + co + ", cnt=" + cnt + "]";
	}

}
