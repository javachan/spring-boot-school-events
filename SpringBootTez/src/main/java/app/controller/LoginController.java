package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private LoginService loginService;

	@Autowired
	public LoginController(LoginService loginService) {
		
		this.loginService = loginService;
	}
	
	
	
	

}
