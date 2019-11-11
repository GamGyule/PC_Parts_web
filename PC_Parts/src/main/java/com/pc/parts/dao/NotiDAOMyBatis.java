package com.pc.parts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.NotiDTO;
import com.pc.parts.dto.SuppleDTO;

@Repository
public class NotiDAOMyBatis implements NotiDAO {
	
    @Autowired
    private SqlSession sqlSession;
    
	@Override
	public void NotiInsert(NotiDTO noti) {
		// TODO Auto-generated method stub
		sqlSession.insert("Notice.notiInsert" ,noti);
	}
	@Override
	public List<NotiDTO> selectNoti(String co) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Notice.notiSelectAll",co);
	}
	@Override
	public String selectname(int pid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Notice.notiSelectName",pid);
	}
	@Override
	public List<NotiDTO> selectNotiMain() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Notice.notiCountMain");
	}
	@Override
	public void NotiFlag(int idx , int flag) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();

		map.put("idx", idx);
		map.put("flag", flag);
		sqlSession.update("Notice.notiflag",map);
	}
	@Override
	public NotiDTO selectIdxNoti(String idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Notice.selectIdxNoti",idx);
	}
	@Override
	public String getLastAI() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("Notice.getLastAI");
	}
	
	

}
