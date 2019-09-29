package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.noti_dto;

public interface NotiDAO {
	public void NotiInsert(noti_dto noti);
	public List<noti_dto> selectNoti();
}
