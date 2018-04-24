package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.EtkinlikDAO;
import app.domain.Etkinlik;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EtkinlikServiceImpl implements EtkinlikService {

	@Autowired
	private  EtkinlikDAO etkinlikDAO;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Etkinlik addEtkinlik(Etkinlik etkinlik) {
		
		return etkinlikDAO.addEtkinlik(etkinlik);
	}

	@Override
	public List<Etkinlik> getEtkinlikler() {
		
		return etkinlikDAO.getEtkinlikler();
	}

	@Override
	public Etkinlik getEtkinlik(int id) {
		
		return etkinlikDAO.getEtkinlik(id);
	}

	@Override
	public void deleteEtkinlik(int id) {
		
		etkinlikDAO.deleteEtkinlik(id);
		
	}
	
	
	
}
