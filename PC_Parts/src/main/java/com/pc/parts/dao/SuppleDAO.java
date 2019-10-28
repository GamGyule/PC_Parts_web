package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.SuppleDTO;

public interface SuppleDAO {
	public List<SuppleDTO> selectSupple(String page);
	public int AllSuppleCnt();
	
	public List<SuppleDTO> selectSuppleName(String Name);
	public List<SuppleDTO> selectSuppleCo(String Co);
	public SuppleDTO SuppleSelectIdx(String Idx);
	
	
}
