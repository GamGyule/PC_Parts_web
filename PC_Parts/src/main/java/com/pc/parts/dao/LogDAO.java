package com.pc.parts.dao;

import java.util.List;

import com.pc.parts.dto.CompanyDTO;
import com.pc.parts.dto.LogDTO;

public interface LogDAO {
	public List<LogDTO> SelectLog();
}
