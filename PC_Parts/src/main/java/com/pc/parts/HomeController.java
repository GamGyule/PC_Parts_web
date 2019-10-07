package com.pc.parts;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pc.parts.dao.NotiDAOMyBatis;
import com.pc.parts.dto.NotiDTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	NotiDAOMyBatis notidao;
	
	@RequestMapping("/")
	public String Index(Model model) {
		
		  List<NotiDTO> noti_list = (List<NotiDTO>) notidao.selectNoti();
		  
		  model.addAttribute("noti_list",noti_list);
		
		return "index";
	}
	
	
	
}
