package com.pc.parts;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	public boolean LoginCheck(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null) {
			return false;
		}
		return true;
	}

	@RequestMapping("/")
	public String Index(Model model) {
		return "login";
	}
	
	@RequestMapping("/smodify")
	public String Smodify(Model model, HttpServletRequest request) {
		String pdIdx = request.getParameter("suppleIdx");
		
		SuppleDTO supple = supdao.SuppleSelectIdx(pdIdx);
		model.addAttribute("supple",supple);
		return "smodify";
	}

	@RequestMapping("/home")
	public String Home(Model model, HttpServletRequest request) {
		if(!LoginCheck(request)) {
			return "login";
		}
		
		List<NotiDTO> noti_list = (List<NotiDTO>) notidao.selectNoti();
		model.addAttribute("noti_list", noti_list);
		return "home";
	}

	@RequestMapping("/loginaction")
	public String LoginAction(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + pw);
		List<CompanyDTO> companyDtoList = (List<CompanyDTO>) comdao.LoginCompany(id, pw);

		model.addAttribute("list", companyDtoList);
		return "formaction/loginAction";
	}

	@RequestMapping("/main")
	public String Main(Model model, HttpServletRequest request) {
		List<NotiDTO> noti_list = (List<NotiDTO>) notidao.selectNoti();

		model.addAttribute("noti_list", noti_list);
		return "home";
	}

	@RequestMapping("/supple")
	public String ProductManaging(Model model, HttpServletRequest request) {
		if(!LoginCheck(request)) {
			return "login";
		}
		
		if(request.getParameter("coName") != null) {
			//회사 이름으로 검색
			
			
		}else if(request.getParameter("name") != null){
			//부품 이름으로 검색
			String name = request.getParameter("name");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleName(name , page);
				model.addAttribute("list", Supple_list);
			} else {
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleName(name ,"1");
				model.addAttribute("list", Supple_list);
			}

			int SuppleCnt = supdao.NameSuppleCnt();
			model.addAttribute("SuppleCnt", SuppleCnt);
			return "supple";
		}else {
			//그냥 보여주는거
			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSupple(page);
				model.addAttribute("list", Supple_list);
			} else {
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSupple("1");
				model.addAttribute("list", Supple_list);
			}

			int SuppleCnt = supdao.AllSuppleCnt();
			model.addAttribute("SuppleCnt", SuppleCnt);
			return "supple";
		}
		
		return null;
		
		
	}

	@RequestMapping("/home/noti")
	public String Noti(Model model) {

		return "noti";

	}
}
