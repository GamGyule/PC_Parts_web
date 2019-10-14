package com.pc.parts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pc.parts.dao.CompanyDAOMyBatis;
import com.pc.parts.dao.NotiDAOMyBatis;
import com.pc.parts.dto.CompanyDTO;
import com.pc.parts.dto.NotiDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	NotiDAOMyBatis notidao;
	
	@Inject
	CompanyDAOMyBatis comdao;
	
	@RequestMapping("/home")
	public String Home(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + pw);
		int cnt = comdao.LoginCompany(id, pw);
		
		if(cnt == 1) {
			List<NotiDTO> noti_list = (List<NotiDTO>) notidao.selectNoti();
			  
			  model.addAttribute("noti_list",noti_list);
			return "home";
		}
		return "login";
	}
	
	@RequestMapping("/")
	public String Index(Model model,HttpServletRequest hsr) {
		String com = hsr.getParameter("com");
		//List<CompanyDTO> Com_list = (List<CompanyDTO>) comdao.LoginCompany();
		
		//model.addAttribute("com",com);
		return "login";
		
	}


	
	
	
	
}
