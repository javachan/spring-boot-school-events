package app.dao;

import java.util.List;

import app.domain.Etkinlik;

public interface EtkinlikDAO {
	
	public Etkinlik addEtkinlik(Etkinlik etkinlik);
	
	public List<Etkinlik> getEtkinlikler();
	
	public List<Etkinlik> getEtkinlikById(int id);
	
	public Etkinlik getEtkinlik(int id);
	
	public Etkinlik deleteEtkinlik(int id);

}
