package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.KonusmaciDAO;
import app.domain.Konusmacim;

@Service("konusmaciService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class KonusmaciServiceImpl implements KonusmaciService {
	
	@Autowired
	private KonusmaciDAO konusmaciDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Konusmacim addKonusmaci(Konusmacim konusmacim) {
		
		return  konusmaciDAO.addKonusmaci(konusmacim);
	}

	@Override
	public List<Konusmacim> getKonusmacilar() {
		
		return konusmaciDAO.getKonusmacilar();
	}

	@Override
	public Konusmacim getKonusmaci(int konusmaciId) {
		
		return konusmaciDAO.getKonusmaci(konusmaciId);
	}

	@Override
	public void deleteKonusmaci(int konusmaciId) {
		
		konusmaciDAO.deleteKonusmaci(konusmaciId);
		
	}

	@Override
	public List<Konusmacim> getKonusmaciById(int konusmaciId) {
		
		return konusmaciDAO.getKonusmaciById(konusmaciId);
	}

	
}
