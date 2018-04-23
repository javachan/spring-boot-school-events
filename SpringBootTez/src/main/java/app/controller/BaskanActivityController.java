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
import app.domain.Baskan;
import app.service.BaskanActivityService;

@Controller
@RequestMapping("/baskanlar")
public class BaskanActivityController {

	private BaskanActivityService baskanActivityService;

	@Autowired
	public BaskanActivityController(BaskanActivityService baskanActivityService) {
		super();
		this.baskanActivityService = baskanActivityService;
	}



	@RequestMapping("/liste")
	public String list(Model model){
		model.addAttribute("baskanlar", baskanActivityService.getBaskanlar());
		return "baskan/liste";
	}

}
