package app.dao;

import java.util.List;

import app.domain.Login;

public interface LoginDAO {

	public Login addLogin(Login login);
	
	public List<Login> getLogins();
	
	public List<Login> getLoginsById(int id);
	
	public Login getLogin(int id);
	
	public Login deleteLogin(int id);
}
