package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.BasvuruDAO;
import app.domain.Basvuru;

@Service("basvuruService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BasvuruServiceImpl implements BasvuruService {

	@Autowired
	private BasvuruDAO basvuruDAO;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Basvuru addBasvuru(Basvuru basvuru) {
	
		return basvuruDAO.addBasvuru(basvuru);
	}

	@Override
	public List<Basvuru> getBasvurular() {
		
		return basvuruDAO.getBasvurular();
	}

	@Override
	public List<Basvuru> getBasvurularById(int bId) {
		
		return basvuruDAO.getBasvurularById(bId);
	}

	@Override
	public Basvuru getBasvuru(int bId) {
		
		return basvuruDAO.getBasvuru(bId);
	}

	@Override
	public Basvuru deleteBasvuru(int bId) {
		
		return basvuruDAO.deleteBasvuru(bId);
	}

}
