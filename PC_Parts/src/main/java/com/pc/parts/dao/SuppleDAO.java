package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.SuppleDTO;

public interface SuppleDAO {
	public List<SuppleDTO> selectSupple(String page);
	public int AllSuppleCnt();
	public int NameSuppleCnt();
	public int CoSuppleCnt();
	public List<SuppleDTO> selectSuppleName(String Name , String spage);
	public List<SuppleDTO> selectSuppleCo(String Co , String spage);

	
	
}
