package com.pc.parts.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.SuppleDTO;

@Repository
public class SuppleDAOMybatis implements SuppleDAO {
	
    @Autowired
    private SqlSession sqlSession;
	@Override
	public List<SuppleDTO> selectSupple() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectAll");
	}

}
