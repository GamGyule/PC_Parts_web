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
	public List<SuppleDTO> selectSupple(String page) {
		// TODO Auto-generated method stub
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
	public List<SuppleDTO> selectSuppleCoPriceD(String Co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoPriceD" ,Co);
	}
	@Override
	public List<SuppleDTO> selectSuppleCoPriceA(String Co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoPriceA" ,Co);
	}
	@Override
	public List<SuppleDTO> selectSuppleCoCntD(String Co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoCntD" ,Co);
	}
	@Override
	public List<SuppleDTO> selectSuppleCoCntA(String Co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectCoCntA" ,Co);
	}
	@Override
	public List<SuppleDTO> selectSuppleNamePriceD(String Name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNamePriceD" , Name);
	}
	@Override
	public List<SuppleDTO> selectSuppleNamePriceA(String Name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNamePriceA" , Name);
	}
	@Override
	public List<SuppleDTO> selectSuppleNameCntD(String Name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNameCntD" , Name);
	}
	@Override
	public List<SuppleDTO> selectSuppleNameCntA(String Name) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Supple.SuppleSelectNameCntA" , Name);
	}
}
