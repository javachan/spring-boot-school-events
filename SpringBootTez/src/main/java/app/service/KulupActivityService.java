package app.service;

import java.util.List;

import app.domain.Baskan;
import app.domain.Kulup;

public interface KulupActivityService {

	
	public Kulup addKulup(Kulup kulup);
	
	public List<Kulup> getKulupler();
	
	public Kulup getKulup(int kulupId);
	
	public void deleteKulup(int kulupId);
	
}
