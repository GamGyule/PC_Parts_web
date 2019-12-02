package com.pc.parts.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogDTO {
	private int logNum;
	private Date logDate;
	private int logPid;
	private int logOld;
	private int logNew;
	private String logCo;
	SimpleDateFormat dateset = new SimpleDateFormat("yyyy-MM-dd");
	public int getLogNum() {
		return logNum;
	}
	public void setLogNum(int logNum) {
		this.logNum = logNum;
	}
	public String getLogDate() {
		return dateset.format(logDate);
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public int getLogPid() {
		return logPid;
	}
	public void setLogPid(int logPid) {
		this.logPid = logPid;
	}
	public int getLogOld() {
		return logOld;
	}
	public void setLogOld(int logOld) {
		this.logOld = logOld;
	}
	public int getLogNew() {
		return logNew;
	}
	public void setLogNew(int logNew) {
		this.logNew = logNew;
	}
	public String getLogCo() {
		return logCo;
	}
	public void setLogCo(String logCo) {
		this.logCo = logCo;
	}
}
