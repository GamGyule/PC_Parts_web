package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.SuppleDTO;

public interface SuppleDAO {
	public List<SuppleDTO> selectSupple();
	public List<SuppleDTO> selectSuppleName(String Name);
	public List<SuppleDTO> selectSuppleCo(String Co);
	public List<SuppleDTO> selectSupplePriceD();
	public List<SuppleDTO> selectSupplePriceA();
	public List<SuppleDTO> selectSuppleCntD();
	public List<SuppleDTO> selectSuppleCntA();
	public List<SuppleDTO> selectSuppleCoPriceD();
	public List<SuppleDTO> selectSuppleCoPriceA();
	public List<SuppleDTO> selectSuppleCoCntD();
	public List<SuppleDTO> selectSuppleCoCntA();
	public List<SuppleDTO> selectSuppleNamePriceD();
	public List<SuppleDTO> selectSuppleNamePriceA();
	public List<SuppleDTO> selectSuppleNameCntD();
	public List<SuppleDTO> selectSuppleNameCntA();
	
	
}
