package app.dao;

import java.util.List;

import app.domain.Etkinlik;

public interface EtkinlikDAO {
	
	public Etkinlik addEtkinlik(Etkinlik etkinlik);
	
	public List<Etkinlik> getEtkinlikler();
	
	public Etkinlik getEtkinlik(int id);
	
	public void deleteEtkinlik(int id);

}
