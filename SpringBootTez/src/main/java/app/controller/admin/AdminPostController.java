package app.controller.admin;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import app.domain.Baskan;
import app.domain.Etkinlik;
import app.domain.Konusmacim;
import app.domain.Kulup;
import app.domain.Login;
import app.service.BaskanActivityService;
import app.service.EtkinlikService;
import app.service.KonusmaciService;
import app.service.KulupActivityService;
import app.service.LoginService;


@Controller
@Secured( {"ROLE_ADMIN"} )
public class AdminPostController {
	
	private KulupActivityService kulupActivityService;
	private BaskanActivityService baskanActivityService;
	private KonusmaciService konusmaciService;
	private EtkinlikService etkinlikService;
	private LoginService loginService;
		
	@Autowired
	public AdminPostController(KulupActivityService kulupActivityService, BaskanActivityService baskanActivityService,
			KonusmaciService konusmaciService, EtkinlikService etkinlikService, LoginService loginService) {
		
		this.kulupActivityService = kulupActivityService;
		this.baskanActivityService = baskanActivityService;
		this.konusmaciService = konusmaciService;
		this.etkinlikService = etkinlikService;
		this.loginService = loginService;
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
		kulupActivityService.addKulup(kulup);
		return new ModelAndView("admin/ayar/bilgi");
	}
	
	@RequestMapping("/admin/baskanlar")
	public String createBaskan(Model model) {
		model.addAttribute("baskan", new Baskan());
		model.addAttribute("baskanlar", baskanActivityService.getBaskanlar());
		return "admin/baskan/addBaskan";
	}
	
	
	@RequestMapping( value = "/admin/baskan/save", method = RequestMethod.POST )
	public String saveBaskan(Baskan baskan) {
		baskanActivityService.addBaskan(baskan);
		return "admin/ayar/bilgi";
	}
	
	
	@RequestMapping("/admin/konusmacilar")
	public String createKonusmaci(Model model) {
		model.addAttribute("konusmaci", new Konusmacim());
		model.addAttribute("konusmacilar", konusmaciService.getKonusmacilar());
		model.addAttribute("kulupler",  kulupActivityService.getKulupler());
		return "admin/konusmaci/addKonusmaci";
	}
	
	@RequestMapping( value = "/admin/konusmaci/save", method = RequestMethod.POST )
	public ModelAndView saveKonusmaci(Konusmacim konusmacim,BindingResult bindingResult) {
		konusmaciService.addKonusmaci(konusmacim);
		return new ModelAndView("admin/ayar/bilgi");
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
		etkinlikService.addEtkinlik(etkinlik);
		return "admin/ayar/bilgi";
	}
	
	@RequestMapping( value = "/admin/etkinlik/delete/{id}",method = RequestMethod.GET)
	public String editEtkinlik(@PathVariable(value="id") Integer id, Model model) {
		etkinlikService.deleteEtkinlik(id);
		return "admin/ayar/bilgi";
	}
	
	@RequestMapping("/admin/konusmacilar/liste")
	public String listKonusmaci(Model model){
		model.addAttribute("konusmacilar", konusmaciService.getKonusmacilar());
		return "admin/konusmaci/liste";
	}

	@RequestMapping("/admin/konusmaci/edit/{konusmaciId}")
	public String editKonusmaci(@PathVariable Integer konusmaciId,Model model) {
		model.addAttribute("konusmaci" , konusmaciService.getKonusmaciById(konusmaciId));
		model.addAttribute("kulupler",  kulupActivityService.getKulupler());
		return "admin/konusmaci/addKonusmaci";
	}

	@RequestMapping("/admin/uye")
	public String createUye(Model model) {
		model.addAttribute("uye", new Login());
		model.addAttribute("uyeler",loginService.getLogins());
		model.addAttribute("baskanlar", baskanActivityService.getBaskanlar());
		return "admin/uye/addUye";
	}
	
	@RequestMapping( value = "/admin/uye/save", method = RequestMethod.POST )
	public String saveUye(Login login) {
		loginService.addLogin(login);
		return "admin/ayar/bilgi";
	}
	
	
	@RequestMapping("/admin/uyeler/liste")
	public String listUye(Model model){
		model.addAttribute("uyeler", loginService.getLogins());
		return "admin/uye/liste";
	}

}
