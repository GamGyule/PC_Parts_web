package com.pc.parts.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pc.parts.dto.CompanyDTO;

public class CompanyDAOMyBatis implements CompanyDAO {
    @Autowired
    private SqlSession sqlSession;
    
	@Override
	public List<CompanyDTO> LoginCompany() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("user.LoginCompany");
	}
		
}
