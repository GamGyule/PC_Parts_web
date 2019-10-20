package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.SuppleDTO;

public interface SuppleDAO {
	public List<SuppleDTO> selectSupple(String page);
	public int AllSuppleCnt();
	
	public List<SuppleDTO> selectSuppleName(String Name);
	public List<SuppleDTO> selectSuppleCo(String Co);
	public List<SuppleDTO> selectSupplePriceD();
	public List<SuppleDTO> selectSupplePriceA();
	public List<SuppleDTO> selectSuppleCntD();
	public List<SuppleDTO> selectSuppleCntA();
	public List<SuppleDTO> selectSuppleCoPriceD(String Co);
	public List<SuppleDTO> selectSuppleCoPriceA(String Co);
	public List<SuppleDTO> selectSuppleCoCntD(String Co);
	public List<SuppleDTO> selectSuppleCoCntA(String Co);
	public List<SuppleDTO> selectSuppleNamePriceD(String Name);
	public List<SuppleDTO> selectSuppleNamePriceA(String Name);
	public List<SuppleDTO> selectSuppleNameCntD(String Name);
	public List<SuppleDTO> selectSuppleNameCntA(String Name);
	
	
}
