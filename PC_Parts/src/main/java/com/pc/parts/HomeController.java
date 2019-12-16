package com.pc.parts;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.pc.parts.dao.ChartDAOMybatis;
import com.pc.parts.dao.CompanyDAOMyBatis;
import com.pc.parts.dao.LogDAOMybatis;
import com.pc.parts.dao.NotiCmtDAOMyBatis;
import com.pc.parts.dao.NotiDAOMyBatis;
import com.pc.parts.dao.SuppleDAOMybatis;
import com.pc.parts.dto.ChartSupRequestDTO;
import com.pc.parts.dto.CompanyDTO;
import com.pc.parts.dto.LogDTO;
import com.pc.parts.dto.NotiCmtDTO;
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

	@Inject
	NotiCmtDAOMyBatis notiCmtDao;
	
	@Inject
	ChartDAOMybatis chartdao;
	
	@Inject
	LogDAOMybatis logdao;

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
		model.addAttribute("suppleLow", suppleLow);
		return "home";

	}

	@RequestMapping("/loginaction")
	public String LoginAction(Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		List<CompanyDTO> companyDtoList = (List<CompanyDTO>) comdao.LoginCompany(id, pw);

		model.addAttribute("list", companyDtoList);
		return "formaction/loginAction";
	}

	@RequestMapping("/updateaction")
	public String flagUpdate(Model model, HttpServletRequest request) {
		String flagUpdate = request.getParameter("flagUpdate");
		String flagUpdate2 = request.getParameter("flagUpdate2");

		int noti_cnt = Integer.parseInt(request.getParameter("noti_cnt"));
		int noti_pid = Integer.parseInt(request.getParameter("noti_pid"));
		String noti_to_co = request.getParameter("noti_to_co");
		String noti_from_co = request.getParameter("noti_from_co");

		if (flagUpdate != null) {
			int idx = Integer.parseInt(flagUpdate);
			notidao.NotiFlag(idx, 1);

		} else {

			int idx = Integer.parseInt(flagUpdate2);
			notidao.NotiFlag(idx, 2);
		}

		notidao.NotiSuppleUpdateTo(noti_cnt, noti_pid, noti_to_co);
		notidao.NotiSuppleUpdateFrom(noti_cnt, noti_pid, noti_from_co);

		return "formaction/updateaction";
	}

	@RequestMapping("/srequest")
	public void ReqeustSupple(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
		HttpSession session = req.getSession();

		CompanyDTO user = (CompanyDTO) session.getAttribute("user");

		String page = req.getParameter("page");

		String cmt_content = req.getParameter("cmt_content");
		String pid = req.getParameter("supplePid");
		String cnt = req.getParameter("suppleCnt");
		String to_co = req.getParameter("suppleComp");
		String from_co = user.getCo();

		int result = supdao.checkSuppleCnt(to_co, pid, cnt);

		if (result < 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�슂泥��븯�뒗 �옱怨좉� �꼫臾� 留롮뒿�땲�떎.');history.back();</script>");
			out.flush();
			return;
		} else {

			supdao.RequestSupple(from_co, to_co, pid, cnt);
			if (cmt_content != "") {
				String noti_lastAI = notidao.getLastAI();
				notiCmtDao.sendReply(noti_lastAI, user.getCo(), cmt_content);
			}

			model.addAttribute("page", page);

			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('�슂泥��븯���뒿�땲�떎.');window.close();</script>");
			out.flush();
			return;
		}
	}

	@RequestMapping("/supple")
	public String ProductManaging(Model model, HttpServletRequest request) {
		if (!LoginCheck(request)) {
			return "login";
		}

		if (request.getParameter("searchCompany") != null && request.getParameter("searchName") != null) {

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

		} else if (request.getParameter("searchCompany") != null && request.getParameter("searchName") == null) {

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

			String name = request.getParameter("searchName");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
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
	
	@RequestMapping("/suppleLowAction")
	public String ProductLowManaging(Model model, HttpServletRequest request) {
		if (!LoginCheck(request)) {
			return "login";
		}

		if (request.getParameter("searchCompany") != null && request.getParameter("searchName") != null) {

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

		} else if (request.getParameter("searchCompany") != null && request.getParameter("searchName") == null) {

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

			String name = request.getParameter("searchName");

			if (request.getParameter("page") != null) {
				String page = request.getParameter("page");
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

		if (request.getParameter("page") != null) {
			String page = request.getParameter("page");
			List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectLowSupple(page);
			model.addAttribute("list", Supple_list);
		} else {
			List<SuppleDTO> Supple_list = (List<SuppleDTO>) supdao.selectLowSupple("1");
			model.addAttribute("list", Supple_list);
		}

		int SuppleCnt = supdao.AllSuppleCnt();
		model.addAttribute("SuppleCnt", SuppleCnt);
		return "suppleLowAction";

	}

	@RequestMapping("/noti")
	public String Noti(Model model, HttpServletRequest req) {
		if (!LoginCheck(req)) {
			return "login";
		}

		HttpSession session = req.getSession();
		CompanyDTO user = (CompanyDTO) session.getAttribute("user");

		List<NotiDTO> Noti_listAll = (List<NotiDTO>) notidao.selectNoti(user.getCo());
		ArrayList<String> Noti_name = new ArrayList<String>();
		ArrayList<Integer> cmtList = new ArrayList<Integer>();

		for (int i = 0; i < Noti_listAll.size(); i++) {
			Noti_name.add(notidao.selectname(Noti_listAll.get(i).getPid()));
			cmtList.add(notiCmtDao.cmtCount(Noti_listAll.get(i).getIdx()));
		}

		model.addAttribute("noti_listAll", Noti_listAll);
		model.addAttribute("noti_nameList", Noti_name);
		model.addAttribute("user", user.getCo());
		model.addAttribute("notiCmtCount", cmtList);
		return "noti";
	}
	@RequestMapping("/log")
	public String Log(Model model) {
		
		List<LogDTO> Log_list = (List<LogDTO>) logdao.SelectLog();
		model.addAttribute("Log_list",Log_list);
		LogDTO log = Log_list.get(0);
		System.out.println(log.getLogCo());
		return "log";
		
	}

	@RequestMapping("/supRequestPage")
	public String SupRequestPage(Model model, HttpServletRequest req) {
		if (!LoginCheck(req)) {
			return "login";
		}

		String idx = req.getParameter("supIdx");

		NotiDTO noti = notidao.selectIdxNoti(idx);
		List<NotiCmtDTO> cmtList = (List<NotiCmtDTO>) notiCmtDao.getSupCmtList(idx);
		String name = notidao.selectname(noti.getPid());

		model.addAttribute("notiInfo", noti);
		model.addAttribute("notiCmtList", cmtList);
		model.addAttribute("notiName", name);

		return "supRequest";
	}

	@ResponseBody
	@RequestMapping("/sendReply")
	public void SendReplay(HttpServletRequest req) {
		String notiIdx = req.getParameter("notiIdx");
		String myComp = req.getParameter("myComp");
		String content = req.getParameter("notiCmtContent");

		notiCmtDao.sendReply(notiIdx, myComp, content);
	}

	@RequestMapping("/importExcel")
	public String importExcel(HttpServletRequest req, MultipartFile files) {
		System.out.println("@@@@@@@@@@@@@@@@@Excel Import@@@@@@@@@@@@@@@@@");
		try {
			File convFile = new File(files.getOriginalFilename());
			files.transferTo(convFile);
			File file = convFile;

			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			
			ArrayList<Object> list = new ArrayList<Object>();
			
			int cnt = 0;
			while (iterator.hasNext()) {

				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();

				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();

					if (currentCell.getCellType() == CellType.STRING) {
						System.out.println(currentCell.getStringCellValue());
						list.add(cnt, currentCell.getStringCellValue());
					} else if (currentCell.getCellType() == CellType.NUMERIC) {
						System.out.println(currentCell.getNumericCellValue());
						list.add(cnt, (int) currentCell.getNumericCellValue());
					}
					cnt++;
					if (cnt == 7) {
						 System.out.println(list.subList(0, cnt));
						 supdao.SuppleInsert(list);
						 cnt = 0;
					}
				}
				System.out.println();

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/supple";
	}
	
	@RequestMapping("/chart")
	public String chartView(HttpServletRequest request) {
		return "chart";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/getChart", produces = "application/json; charset=utf8")
	public String getChart(HttpServletRequest req) {
		String co = req.getParameter("co");
		List<ChartSupRequestDTO> list = chartdao.getRequestChart(co);
		
		Gson gson = new Gson();
		String data = gson.toJson(list);
		
		return data;
	}
}
