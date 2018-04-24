package app.dao;

import java.util.List;


import app.domain.Konusmaci;

public interface KonusmaciDAO {
	
	public Konusmaci addKonusmaci(Konusmaci konusmaci);
	
	public List<Konusmaci> getKonusmacilar();
	
	public Konusmaci getKonusmaci(int konusmaciId);
	
	public void deleteKonusmaci(int konusmaciId);

}
