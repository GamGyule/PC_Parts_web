package com.pc.parts.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pc.parts.dto.CompanyDTO;

@Repository
public class CompanyDAOMyBatis implements CompanyDAO {
    @Autowired
    private SqlSession sqlSession;
    
	@Override
	public List<CompanyDTO> LoginCompany(String id, String pw) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);
		return sqlSession.selectList("company.LoginCompany",map);
	}
		
}
