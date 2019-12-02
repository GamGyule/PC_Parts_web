package com.pc.parts.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChartSupRequestDTO {
	
	private int pid;
	private String name;
	private String co;
	private int cnt;
	private String date;
	private int price;
	
	SimpleDateFormat dateset = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getDate() {
		return dateset.format(date);
	}
	public void setDate(String date) {
		this.date = dateset.format(date);
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
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
	@Override
	public String toString() {
		return "ChartSupRequestDTO [pid=" + pid + ", name=" + name + ", co=" + co + ", cnt=" + cnt + "]";
	}
	
	
	
	
	
	
}
