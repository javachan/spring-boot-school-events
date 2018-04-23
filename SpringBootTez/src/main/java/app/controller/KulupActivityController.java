package app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import app.domain.Kulup;
import app.service.BaskanActivityService;
import app.service.KulupActivityService;

@Controller
@RequestMapping("/kulupler")
public class KulupActivityController {

	private KulupActivityService kulupActivityService;

	@Autowired
	public KulupActivityController(KulupActivityService kulupActivityService) {
		super();
		this.kulupActivityService = kulupActivityService;
	}
	
	@RequestMapping("/liste")
	public String list(Model model){
		model.addAttribute("kulupler", kulupActivityService.getKulupler() );
		return "kulup/liste";
	}

	
}
