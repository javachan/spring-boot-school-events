package app.service;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.LoginDAO;
import app.domain.Login;

@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Login addLogin(Login login) {
	
		return loginDAO.addLogin(login);
	}

	@Override
	public List<Login> getLogins() {
		
		return loginDAO.getLogins();
	}



	@Override
	public Login getLogin(int id) {
		
		return loginDAO.getLogin(id);
	}

	@Override
	public Login deleteLogin(int id) {
		
		return loginDAO.deleteLogin(id);
	}

	@Override
	public List<Login> getLoginsById(int id) {
		
		return loginDAO.getLoginsById(id);
	}


}
