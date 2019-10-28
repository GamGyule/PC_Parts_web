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
		Map<String,String> map = new HashMap<String, String>();
		int page = (Integer.parseInt(spage)-1)*15;
		String npage = Integer.toString(page);
		map.put("name", Name);
		map.put("spage", npage);
		return sqlSession.selectList("Supple.SuppleSelectName" , map);
	}
	@Override
	public List<SuppleDTO> selectSuppleCo(String Co , String spage) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		int page = (Integer.parseInt(spage)-1)*15;
		String npage = Integer.toString(page);
		map.put("co", Co);
		map.put("spage", npage);
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

}
