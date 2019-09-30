package com.pc.parts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pc.parts.dto.noti_dto;

public class NotiDAOMyBatis implements NotiDAO {
	
    @Autowired
    private SqlSession sqlSession;
	@Override
	public void NotiInsert(noti_dto noti) {
		// TODO Auto-generated method stub
		sqlSession.insert("Notice.notiInsert" ,noti);
	}
	@Override
	public List<noti_dto> selectNoti() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("Notice.notiSelectAll");
	}

}
