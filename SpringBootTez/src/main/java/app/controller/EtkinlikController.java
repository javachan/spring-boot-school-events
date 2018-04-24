package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.EtkinlikService;

@Controller
@RequestMapping("/etkinlikler")
public class EtkinlikController {
	
	private EtkinlikService etkinlikService;

	@Autowired
	public EtkinlikController(EtkinlikService etkinlikService) {
		super();
		this.etkinlikService = etkinlikService;
	}
	
	
	@RequestMapping("/liste")
	public String list(Model model){
		model.addAttribute("etkinlikler", etkinlikService.getEtkinlikler());
		return "etkinlik/liste";
	}

	@RequestMapping("/gorunum/{id}")
	public String view(@PathVariable(value="id") int id, Model model){
		model.addAttribute("etkinlikler", etkinlikService.getEtkinlikById(id));
		return "etkinlik/gorunum";
	}
	

}
