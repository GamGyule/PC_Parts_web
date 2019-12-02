package com.pc.parts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public List<ChartSupRequestDTO> selectDateChart(String fdate, String edate) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		map.put("fdate", fdate);
		map.put("edate", edate);
		return sqlSession.selectList("Chart.selectDateChart",map);
	}

	@Override
	public List<ChartSupRequestDTO> selectProductChart(String pid) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Chart.selectProductChart",pid);
	}

}
