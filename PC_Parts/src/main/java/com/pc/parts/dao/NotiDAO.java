package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.NotiDTO;

public interface NotiDAO {
	public void NotiInsert(NotiDTO noti);
	public List<NotiDTO> selectNoti();
}
