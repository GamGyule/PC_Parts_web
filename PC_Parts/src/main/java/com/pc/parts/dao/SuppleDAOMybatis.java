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
	@Override
	public List<SuppleDTO> selectSuppleName() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectName");
	}
	@Override
	public List<SuppleDTO> selectSuppleCo() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCo");
	}
	@Override
	public List<SuppleDTO> selectSupplePriceD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectPriceD");
	}
	@Override
	public List<SuppleDTO> selectSupplePriceA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectPriceA");
	}
	@Override
	public List<SuppleDTO> selectSuppleCntD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCntD");
	}
	@Override
	public List<SuppleDTO> selectSuppleCntA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCntA");
	}
	@Override
	public List<SuppleDTO> selectSuppleCoPriceD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoPriceD");
	}
	@Override
	public List<SuppleDTO> selectSuppleCoPriceA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoPriceA");
	}
	@Override
	public List<SuppleDTO> selectSuppleCoCntD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoCntD");
	}
	@Override
	public List<SuppleDTO> selectSuppleCoCntA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoCntA");
	}
	@Override
	public List<SuppleDTO> selectSuppleNamePriceD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNamePriceD");
	}
	@Override
	public List<SuppleDTO> selectSuppleNamePriceA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNamePriceA");
	}
	@Override
	public List<SuppleDTO> selectSuppleNameCntD() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNameCntD");
	}
	@Override
	public List<SuppleDTO> selectSuppleNameCntA() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNameCntA");
	}

}
