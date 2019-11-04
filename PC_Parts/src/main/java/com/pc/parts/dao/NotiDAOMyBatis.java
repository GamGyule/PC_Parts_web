package com.pc.parts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.NotiDTO;

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
	public List<NotiDTO> selectNotiMain() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Notice.notiCountMain");
	}
	@Override
	public void NotiFlag(int idx) {
		// TODO Auto-generated method stub
		sqlSession.update("Supple.SuppleUpdate",idx);
		
	}

}
