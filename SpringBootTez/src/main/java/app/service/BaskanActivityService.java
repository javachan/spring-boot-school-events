package app.service;

import java.util.List;

import app.domain.Baskan;

public interface BaskanActivityService {

	
    public Baskan addBaskan(Baskan baskan);
	
	public List<Baskan> getBaskanlar();
	
	public Baskan getBaskan(int baskanId);
	
	public void deleteBaskan(int baskanId);
}
