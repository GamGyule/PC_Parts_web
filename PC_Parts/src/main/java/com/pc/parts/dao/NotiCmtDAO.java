package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.NotiCmtDTO;

public interface NotiCmtDAO {
	public List<NotiCmtDTO> getSupCmtList(String idx);
	public void sendReply(String idx,String comp, String content);
	public int cmtCount(int idx);
}
