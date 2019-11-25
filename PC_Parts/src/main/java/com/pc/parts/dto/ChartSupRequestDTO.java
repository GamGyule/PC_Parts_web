package com.pc.parts.dto;

public class ChartSupRequestDTO {
	
	private int pid;
	private String name;
	private String co;
	private int cnt;
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
