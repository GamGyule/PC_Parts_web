package com.pc.parts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.LogDTO;
@Repository
public class LogDAOMybatis implements LogDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<LogDTO> SelectLog() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("log.selectlog");
	}

}
