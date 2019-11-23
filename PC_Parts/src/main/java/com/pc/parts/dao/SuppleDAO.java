package com.pc.parts.dao;

import java.util.ArrayList;
import java.util.List;

import com.pc.parts.dto.SuppleDTO;

public interface SuppleDAO {
	public List<SuppleDTO> selectSupple(String page);
	public int AllSuppleCnt();

	public int NameSuppleCnt(String name);
	public int CoSuppleCnt(String co);
	public List<SuppleDTO> selectSuppleName(String Name , String spage);
	public List<SuppleDTO> selectSuppleCo(String Co , String spage);
	public SuppleDTO SuppleSelectIdx(String Idx);
	
	public void SuppleDelete(String idx);
	public void SuppleUpdate(SuppleDTO supple);
	
	
	public int CoNameSuppleCnt(String co, String name);
	public List<SuppleDTO> selectSuppleCoName(String co ,String name , String page);
	public int SuppleSelectLow();
	
	public int RequestSupple(String from_co, String to_co, String pid, String cnt);
	public int checkSuppleCnt(String to_co, String pid, String cnt);
	
	public void SuppleInsert(ArrayList<Object> list);
	
	
}
