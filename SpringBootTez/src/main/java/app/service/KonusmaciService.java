package app.service;

import java.util.List;

import app.domain.Konusmacim;

public interface KonusmaciService {
	
    public Konusmacim addKonusmaci(Konusmacim konusmacim);
	
	public List<Konusmacim> getKonusmacilar();
	
	public List<Konusmacim> getKonusmaciById(int konusmaciId);
	
	public Konusmacim getKonusmaci(int konusmaciId);
	
	public void deleteKonusmaci(int konusmaciId);

}
