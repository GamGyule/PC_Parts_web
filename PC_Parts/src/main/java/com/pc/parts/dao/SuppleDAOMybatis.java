package com.pc.parts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<SuppleDTO> selectSuppleName(String Name , String spage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		int page = (Integer.parseInt(spage)-1)*15;
		map.put("name", Name);
		map.put("spage", page);
		return sqlSession.selectList("Supple.SuppleSelectName" , map);
	}
	@Override
	public List<SuppleDTO> selectSuppleCo(String Co , String spage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		int page = (Integer.parseInt(spage)-1)*15;

		map.put("co", Co);
		map.put("spage", page);
		return sqlSession.selectList("Supple.SuppleSelectCo" , map);
	}
	@Override
	public int NameSuppleCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.NameSuppleCnt");
	}
	@Override
	public int CoSuppleCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.CoSuppleCnt");
	}
	@Override
	public SuppleDTO SuppleSelectIdx(String idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.SuppleSelectIdx",idx);
	}
	@Override
	public void SuppleDelete(String idx) {
		// TODO Auto-generated method stub
		sqlSession.delete("Supple.SuppleDelete",idx);
	}
	@Override
	public void SuppleUpdate(SuppleDTO supple) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("idx",supple.getIdx());
		map.put("price",supple.getPrice());
		map.put("count",supple.getCnt());
		map.put("name",supple.getName());
		map.put("info",supple.getInfo());
		sqlSession.update("Supple.SuppleUpdate",map);
	}


	

}
