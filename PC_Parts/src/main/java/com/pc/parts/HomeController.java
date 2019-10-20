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

	@RequestMapping("/")
	public String Index(Model model) {
		return "login";
	}

	@RequestMapping("/home")
	public String Home(Model model, HttpServletRequest request) {
		return "home";
		/*
		 * String id = request.getParameter("id"); String pw =
		 * request.getParameter("pw"); System.out.println(id + pw); int cnt =
		 * comdao.LoginCompany(id, pw);
		 * 
		 * if(cnt == 1) { List<NotiDTO> noti_list = (List<NotiDTO>)
		 * notidao.selectNoti();
		 * 
		 * model.addAttribute("noti_list",noti_list); return "home"; } return "login";
		 */
	}

	@RequestMapping("/main")
	public String Main(Model model, HttpServletRequest request) {
		return "home";
	}

	@RequestMapping("/supple")
	public String ProductManaging(Model model, HttpServletRequest request) {
		/*if(request.getParameter("page") != null) {
			String page = request.getParameter("page");
			List<SuppleDTO> Supple_list = (List<SuppleDTO>)supdao.selectSupple(page);
			model.addAttribute("list", Supple_list);
		}else {
			List<SuppleDTO> Supple_list = (List<SuppleDTO>)supdao.selectSupple("1");
			model.addAttribute("list", Supple_list);
		}*/
		
		//int SuppleCnt = supdao.AllSuppleCnt();
		//model.addAttribute("SuppleCnt",SuppleCnt);
		return "supple";
	}

	@RequestMapping("/home/noti")
	public String Noti(Model model) {

		return "noti";

	}
}
