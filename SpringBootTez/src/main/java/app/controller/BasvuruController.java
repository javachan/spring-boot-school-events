package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.domain.Baskan;
import app.domain.Basvuru;
import app.service.BasvuruService;

@Controller
@RequestMapping("/basvurular")
public class BasvuruController {

	private BasvuruService basvuruService;

	@Autowired
	public BasvuruController(BasvuruService basvuruService) {
		
		this.basvuruService = basvuruService;
	}
	
	@RequestMapping("/add")
	public String createBasvuru(Model model) {
		model.addAttribute("basvuru", new Basvuru());
		model.addAttribute("basvurular", basvuruService.getBasvurular());
		return "basvuru/addBasvuru";
	}
	
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public String saveBasvuru(Basvuru basvuru) {
		basvuruService.addBasvuru(basvuru);
		return "basvuru/bilgi";
	}
	
	
}
