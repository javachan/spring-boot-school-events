package app.controller.user;

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

import app.domain.Etkinlik;
import app.domain.Konusmacim;
import app.service.EtkinlikService;
import app.service.KonusmaciService;
import app.service.KulupActivityService;

@Controller
@Secured( {"ROLE_USER"} )
public class UserPostController {

	private KulupActivityService kulupActivityService;
	private EtkinlikService etkinlikService;
	private KonusmaciService konusmaciService;
	
	@Autowired
	public UserPostController(KulupActivityService kulupActivityService, EtkinlikService etkinlikService,
			KonusmaciService konusmaciService) {
		
		this.kulupActivityService = kulupActivityService;
		this.etkinlikService = etkinlikService;
		this.konusmaciService = konusmaciService;
	}
	
	@RequestMapping("/user/etkinlikler")
	public ModelAndView createEtkinlik(Etkinlik etkinlik,BindingResult bindingResult){
		Map<String, Object> model = new HashMap<String,Object>();
		model.put("etkinlikler",  etkinlikService.getEtkinlikler());
		model.put("kulupler",  kulupActivityService.getKulupler());
		model.put("konusmacilar", konusmaciService.getKonusmacilar());
		return new ModelAndView("user/etkinlik/addEtkinlik",model);
	}
	

	@RequestMapping( value = "/user/etkinlik/save", method = RequestMethod.POST )
	public String saveEtkinlik(Etkinlik etkinlik) {
		etkinlikService.addEtkinlik(etkinlik);
		return "user/ayar/bilgi";
	}
	
	@RequestMapping("/user/konusmacilar")
	public String createKonusmaci(Model model) {
		model.addAttribute("konusmaci", new Konusmacim());
		model.addAttribute("konusmacilar", konusmaciService.getKonusmacilar());
		model.addAttribute("kulupler",  kulupActivityService.getKulupler());
		return "user/konusmaci/addKonusmaci";
	}
	
	@RequestMapping( value = "/user/konusmaci/save", method = RequestMethod.POST )
	public ModelAndView saveKonusmaci(Konusmacim konusmacim,BindingResult bindingResult) {
		konusmaciService.addKonusmaci(konusmacim);
		return new ModelAndView("user/ayar/bilgi");
	}
	
	
}
