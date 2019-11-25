package com.pc.parts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.ChartSupRequestDTO;

@Repository
public class ChartDAOMybatis implements ChartDAO {

	@Autowired
    private SqlSession sqlSession;

	@Override
	public List<ChartSupRequestDTO> getRequestChart(String co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Chart.gerRequestSup",co);
	}

}
