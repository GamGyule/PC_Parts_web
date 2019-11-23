package com.pc.parts.dao;

import java.util.ArrayList;
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
		int page = (Integer.parseInt(spage)-1)*20;
		return sqlSession.selectList("Supple.SuppleSelectAll",page);
	}
	@Override
	public int AllSuppleCnt() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.AllSuppleCnt");
	}
	@Override

	public List<SuppleDTO> selectSuppleName(String name , String spage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		int page = (Integer.parseInt(spage)-1)*20;
		map.put("name", name);
		map.put("page", page);

		return sqlSession.selectList("Supple.SuppleSelectName" , map);
	}
	@Override
	public List<SuppleDTO> selectSuppleCo(String Co , String spage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		int page = (Integer.parseInt(spage)-1)*20;

		map.put("co", Co);
		map.put("page", page);
		return sqlSession.selectList("Supple.SuppleSelectCo" , map);
	}
	@Override
	public int NameSuppleCnt(String name) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("name", name);
		
		return sqlSession.selectOne("Supple.NameSuppleCnt",map);
	}
	@Override
	public int CoSuppleCnt(String co) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("co", co);
		return sqlSession.selectOne("Supple.CoSuppleCnt",map);
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
	
	
	@Override
	public int CoNameSuppleCnt(String co, String name) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("co", co);
		map.put("name",name);
		return sqlSession.selectOne("Supple.CoNameSuppleCnt",map);
	}
	@Override
	public List<SuppleDTO> selectSuppleCoName(String co, String name, String spage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		int page = (Integer.parseInt(spage)-1)*20;

		map.put("co", co);
		map.put("name", name);
		map.put("page", page);
		return sqlSession.selectList("Supple.SuppleSelectCoName" , map);
	}
	@Override
	public int SuppleSelectLow() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Supple.SuppleSelectLow");
	}
	@Override
	public int RequestSupple(String from_co, String to_co, String pid, String cnt) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("from_co", from_co);
		map.put("to_co", to_co);
		map.put("pid", pid);
		map.put("cnt", cnt);
		
		
		return sqlSession.insert("Supple.SuppleRequest",map);
	}
	@Override
	public int checkSuppleCnt(String to_co, String pid, String cnt) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("to_co", to_co);
		map.put("pid", pid);
		map.put("cnt", cnt);
		return sqlSession.selectOne("Supple.CheckSuppleCnt",map);
	}
	@Override
	public void SuppleInsert(ArrayList<Object> list) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("idx" , list.get(0).toString());
		map.put("pid" , list.get(1).toString());
		map.put("co" , list.get(2).toString());
		map.put("name" , list.get(3).toString());
		map.put("info" , list.get(4).toString());
		map.put("price" , list.get(5).toString());
		map.put("count" , list.get(6).toString());
		
		sqlSession.insert("Supple.SuppleExcelInsert",map);
		
	}


	

}
