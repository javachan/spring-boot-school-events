package app.controller.admin;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.domain.Baskan;
import app.domain.Kulup;
import app.service.BaskanActivityService;
import app.service.KulupActivityService;


@Controller
@Secured( {"ROLE_ADMIN"} )
public class AdminPostController {
	
	private KulupActivityService kulupActivityService;
	private BaskanActivityService baskanActivityService;
		
	@Autowired
	public AdminPostController(KulupActivityService kulupActivityService,
			BaskanActivityService baskanActivityService) {
			
		this.kulupActivityService = kulupActivityService;
		this.baskanActivityService = baskanActivityService;
		
	}

	@RequestMapping("/admin/kulupler")
	public ModelAndView createKulup(Kulup kulup,BindingResult bindingResult){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		model.put("kulupler", kulupActivityService.getKulupler());
		return new ModelAndView("admin/kulup/addKulup",model);
	}

	@RequestMapping( value = "/admin/kulup/save", method = RequestMethod.POST )
	public ModelAndView saveKulup(Kulup kulup,BindingResult bindingResult,Baskan baskan){
		Kulup savedKulup = kulupActivityService.addKulup(kulup);
		return new ModelAndView("redirect:/admin/kulup/" + savedKulup.getKulupId());
	}
	
	@RequestMapping("/admin/baskanlar")
	public String createBaskan(Model model) {
		model.addAttribute("baskan", new Baskan());
		model.addAttribute("baskanlar", baskanActivityService.getBaskanlar());
		return "admin/baskan/addBaskan";
	}
	
	@RequestMapping( value = "/admin/baskan/save", method = RequestMethod.POST )
	public String saveBaskan(Baskan baskan) {
		Baskan savedBaskan = baskanActivityService.addBaskan(baskan);
		return "redirect:/admin/baskan/" + savedBaskan.getBaskanId();
	}
	
	
}
