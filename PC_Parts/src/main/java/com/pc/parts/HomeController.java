package com.pc.parts;

import java.util.HashMap;
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
		if (session.getAttribute("user") == null) {
			return false;
		}
		return true;
	}

	@RequestMapping("/")
	public String Index(Model model) {
		return "login";
	}

	@RequestMapping("/sdelete")
	public void Sdelete(HttpServletRequest request) {
		String idx = request.getParameter("suppleIdx");
		System.out.println("Delete > " + idx);
		supdao.SuppleDelete(idx);
	}

	@RequestMapping("/supdate")
	public void Supdate(HttpServletRequest request) {
		String idx = request.getParameter("suppleIdx");

		String price = request.getParameter("supplePrice");
		String count = request.getParameter("suppleCount");
		String name = request.getParameter("suppleName");
		String info = request.getParameter("suppleInfo");

		int i_price = Integer.parseInt(price);
		int i_count = Integer.parseInt(count);

		SuppleDTO supple = new SuppleDTO(idx, 0, "update", name, info, i_price, i_count);
		System.out.println("Update > " + supple.getIdx());
		System.out.println(supple.getIdx());
		supdao.SuppleUpdate(supple);
	}

	@RequestMapping("/smodify")
	public String Smodify(Model model, HttpServletRequest request) {
		if (!LoginCheck(request)) {
			return "login";
		}

		String pdIdx = request.getParameter("suppleIdx");

		SuppleDTO supple = supdao.SuppleSelectIdx(pdIdx);
		model.addAttribute("supple", supple);
		return "smodify";
	}

	@RequestMapping("/home")
	public String Home(Model model, HttpServletRequest request) {
		if (!LoginCheck(request)) {
			return "login";
		}

		List<NotiDTO> noti_list = (List<NotiDTO>) notidao.selectNotiMain();
		model.addAttribute("noti_list", noti_list);
		
		int suppleLow = supdao.SuppleSelectLow();
		model.addAttribute("suppleLow",suppleLow);
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



	@RequestMapping("/supple")
	public String ProductManaging(Model model, HttpServletRequest request) {
		if (!LoginCheck(request)) {
			return "login";
		}

		if (request.getParameter("searchCompany") != null && request.getParameter("searchName") != null) {

			System.out.println("회사검색 및 이름 검색");
			String co = request.getParameter("searchCompany");
			String name = request.getParameter("searchName");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleCoName(co, name, page);
				model.addAttribute("list", Supple_list);
			} else {
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleCoName(co, name, "1");
				model.addAttribute("list", Supple_list);
			}

			int SuppleCnt = supdao.CoNameSuppleCnt(co, name);
			model.addAttribute("SuppleCnt", SuppleCnt);
			return "supple";

		}else if (request.getParameter("searchCompany") != null && request.getParameter("searchName") == null) {

			System.out.println("회사검색");
			String co = request.getParameter("searchCompany");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleCo(co, page);
				model.addAttribute("list", Supple_list);
			} else {
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleCo(co, "1");
				model.addAttribute("list", Supple_list);
			}

			int SuppleCnt = supdao.CoSuppleCnt(co);
			model.addAttribute("SuppleCnt", SuppleCnt);
			return "supple";

		} else if (request.getParameter("searchCompany") == null && request.getParameter("searchName") != null) {
			// 부품 이름으로 검색
			System.out.println("이름검색");

			String name = request.getParameter("searchName");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
				System.out.println(page);
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleName(name, page);
				model.addAttribute("list", Supple_list);
			} else {
				List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectSuppleName(name, "1");
				model.addAttribute("list", Supple_list);
			}

			int SuppleCnt = supdao.NameSuppleCnt(name);
			model.addAttribute("SuppleCnt", SuppleCnt);
			return "supple";
		}

		System.out.println("그냥 보여줌");
		if (request.getParameter("page") != null) {
			String page = request.getParameter("page");
			System.out.println(page);
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

	@RequestMapping("/noti")
	public String Noti(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		CompanyDTO user = (CompanyDTO) session.getAttribute("user");
		
		List<NotiDTO> Noti_listAll = (List<NotiDTO>) notidao.selectNoti(user.getCo());
		model.addAttribute("noti_listAll" , Noti_listAll);
		model.addAttribute("user",user.getCo());
		return "noti";

	}
}
