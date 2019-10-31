package com.pc.parts.dto;

public class SuppleDTO {

	private String idx;
	private int pid;
	private String co;
	private String name;
	private String info;
	private int price;
	private int count;
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return count;
	}

	public void setCnt(int cnt) {
		this.count = cnt;
	}

	public SuppleDTO(String idx, int pid, String co, String name, String info, int price, int count) {
		this.idx = idx;
		this.pid = pid;
		this.co = co;
		this.name = name;
		this.info = info;
		this.price = price;
		this.count = count;
	}	

}
