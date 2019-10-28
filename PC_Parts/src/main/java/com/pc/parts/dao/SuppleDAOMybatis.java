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
	public List<SuppleDTO> selectSupple(String spage) {
		// TODO Auto-generated method stub
		int page = (Integer.parseInt(spage)-1)*15;
		return sqlSession.selectList("Supple.SuppleSelectAll",page);
	}
	@Override
	public int AllSuppleCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.AllSuppleCnt");
	}
	@Override
	public List<SuppleDTO> selectSuppleName(String Name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectName" , Name);
	}
	@Override
	public List<SuppleDTO> selectSuppleCo(String Co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCo" , Co);
	}
	@Override
	public SuppleDTO SuppleSelectIdx(String idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.SuppleSelectIdx",idx);
	}
}
