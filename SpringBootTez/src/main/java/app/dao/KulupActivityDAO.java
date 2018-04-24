package app.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.domain.Baskan;
import app.domain.Kulup;

public interface KulupActivityDAO{
	
	public Kulup addKulup(Kulup kulup);
	
	public List<Kulup> getKulupler();
	
	//public List<Kulup> getKuluplerById(int kulupId);
	
	public Kulup getKulup(int kulupId);
	
	public void deleteKulup(int kulupId);
	
	

}
