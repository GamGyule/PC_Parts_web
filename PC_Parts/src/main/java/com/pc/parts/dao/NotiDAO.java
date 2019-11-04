package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.NotiDTO;
import com.pc.parts.dto.SuppleDTO;

public interface NotiDAO {
	public void NotiInsert(NotiDTO noti);
	public List<NotiDTO> selectNoti(String co);
	public String selectname(int pid);
	public List<NotiDTO>  selectNotiMain();
	public void NotiFlag(int idx);
}
