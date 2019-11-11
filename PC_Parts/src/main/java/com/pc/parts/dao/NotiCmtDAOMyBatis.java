package com.pc.parts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.NotiCmtDTO;

@Repository
public class NotiCmtDAOMyBatis implements NotiCmtDAO{
	
    @Autowired
    private SqlSession sqlSession;
    
	@Override
	public List<NotiCmtDTO> getSupCmtList(String idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("notiCmt.CmtList",idx);
	}

	@Override
	public void sendReply(String idx,String comp, String content) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("notiIdx", idx);
		map.put("cmt_comp", comp);
		map.put("cmt_content", content);
		
		sqlSession.insert("notiCmt.SendReply",map);
	}

	@Override
	public int cmtCount(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notiCmt.notiCount",idx);
	}

}
