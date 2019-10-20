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
import com.pc.parts.dao.SuppleDAOMybatis;
import com.pc.parts.dto.CompanyDTO;
import com.pc.parts.dto.NotiDTO;
import com.pc.parts.dto.SuppleDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	NotiDAOMyBatis notidao;
	
	@Inject
	CompanyDAOMyBatis comdao;
	
	@Inject
	SuppleDAOMybatis supdao;
	
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
	public String Index(Model model) {

		return "login";
		
	}
	
	@RequestMapping("/home/noti")
	public String Noti(Model model) {
		
		return "noti";
		
	}
	@RequestMapping("/home/Supple")
	public String Supple(Model model) {
		List<SuppleDTO> Supple_List = (List<SuppleDTO>) supdao.selectSupple();
			model.addAttribute("Supple_List" , Supple_List);
		return "supple";
	}


	
	
	
	
}
