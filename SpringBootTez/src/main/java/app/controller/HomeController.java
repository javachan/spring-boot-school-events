package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.EtkinlikService;

@Controller
public class HomeController {
	
	private EtkinlikService etkinlikService;
	
	@Autowired
	public HomeController(EtkinlikService etkinlikService) {
		this.etkinlikService = etkinlikService;
	}
	


	/*@RequestMapping("/")
	public String home(){
		return "home";
	}*/
	@RequestMapping("/")
	public String home(Model model){
		model.addAttribute("etkinlikler", etkinlikService.getEtkinlikler());
		return "index";
	}

}
