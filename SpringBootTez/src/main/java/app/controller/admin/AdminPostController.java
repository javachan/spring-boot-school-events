package app.controller.admin;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.domain.Baskan;
import app.domain.Etkinlik;
import app.domain.Konusmaci;
import app.domain.Kulup;
import app.service.BaskanActivityService;
import app.service.EtkinlikService;
import app.service.KonusmaciService;
import app.service.KulupActivityService;


@Controller
@Secured( {"ROLE_ADMIN"} )
public class AdminPostController {
	
	private KulupActivityService kulupActivityService;
	private BaskanActivityService baskanActivityService;
	private KonusmaciService konusmaciService;
	private EtkinlikService etkinlikService;
		
	@Autowired
	public AdminPostController(KulupActivityService kulupActivityService, BaskanActivityService baskanActivityService,
			KonusmaciService konusmaciService, EtkinlikService etkinlikService) {
		
		this.kulupActivityService = kulupActivityService;
		this.baskanActivityService = baskanActivityService;
		this.konusmaciService = konusmaciService;
		this.etkinlikService = etkinlikService;
	}

	@RequestMapping("/admin/kulupler")
	public ModelAndView createKulup(Kulup kulup,BindingResult bindingResult){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("baskanlar",  baskanActivityService.getBaskanlar());
		model.put("kulupler", kulupActivityService.getKulupler());
		return new ModelAndView("admin/kulup/addKulup",model);
	}

	@RequestMapping( value = "/admin/kulup/save", method = RequestMethod.POST )
	public ModelAndView saveKulup(Kulup kulup,BindingResult bindingResult){
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
	
	
	@RequestMapping("/admin/konusmacilar")
	public String createKonusmaci(Model model) {
		model.addAttribute("konusmaci", new Konusmaci());
		model.addAttribute("konusmacilar", konusmaciService.getKonusmacilar());
		model.addAttribute("kulupler",  kulupActivityService.getKulupler());
		return "admin/konusmaci/addKonusmaci";
	}
	
	@RequestMapping( value = "/admin/konusmaci/save", method = RequestMethod.POST )
	public String saveKonusmaci(Konusmaci konusmaci) {
		Konusmaci savedKonusmaci = konusmaciService.addKonusmaci(konusmaci);
		return "redirect:/admin/konusmaci/" + savedKonusmaci.getKonusmaciId();
	}
	
	@RequestMapping("/admin/etkinlikler")
	public ModelAndView createEtkinlik(Etkinlik etkinlik,BindingResult bindingResult){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("etkinlikler",  etkinlikService.getEtkinlikler());
		model.put("kulupler",  kulupActivityService.getKulupler());
		model.put("konusmacilar", konusmaciService.getKonusmacilar());
		return new ModelAndView("admin/etkinlik/addEtkinlik",model);
	}
	
	@RequestMapping( value = "/admin/etkinlik/save", method = RequestMethod.POST )
	public String saveEtkinlik(Etkinlik etkinlik) {
		Etkinlik savedEtkinlik = etkinlikService.addEtkinlik(etkinlik);
		return "redirect:/admin/etkinlik/" + savedEtkinlik.getId();
	}
}
