package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.KonusmaciService;

@Controller
@RequestMapping("/konusmacilar")
public class KonusmaciController {
	
	private KonusmaciService konusmaciService;

	@Autowired
	public KonusmaciController(KonusmaciService konusmaciService) {
		super();
		this.konusmaciService = konusmaciService;
	}
	
	@RequestMapping("/liste")
	public String list(Model model){
		model.addAttribute("konusmacilar", konusmaciService.getKonusmacilar());
		return "konusmaci/liste";
	}

	

}
