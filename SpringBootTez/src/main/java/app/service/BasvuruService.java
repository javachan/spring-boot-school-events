package app.service;

import java.util.List;

import app.domain.Basvuru;

public interface BasvuruService {
	
	public Basvuru addBasvuru(Basvuru basvuru);
	
	public List<Basvuru> getBasvurular();
	
	public List<Basvuru> getBasvurularById(int bId);
	
	public Basvuru getBasvuru(int bId);
	
	public Basvuru deleteBasvuru(int bId);


}
