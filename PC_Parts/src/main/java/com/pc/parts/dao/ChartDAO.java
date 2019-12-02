package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.ChartSupRequestDTO;


public interface ChartDAO {
	public List<ChartSupRequestDTO> getRequestChart(String co);
	public List<ChartSupRequestDTO> selectDateChart(String fdate , String edate);
	public List<ChartSupRequestDTO> selectProductChart(String pid);
}
