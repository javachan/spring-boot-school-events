package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import app.dao.KulupActivityDAO;
import app.domain.Baskan;
import app.domain.Kulup;

@Service("kulupService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class KulupActivityServiceImpl implements KulupActivityService {

	@Autowired
	private KulupActivityDAO kulupActivityDAO;
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Kulup addKulup(Kulup kulup) {
		
		return kulupActivityDAO.addKulup(kulup);
		
	}

	@Override
	public List<Kulup> getKulupler() {
	
		return kulupActivityDAO.getKulupler();
	}

	@Override
	public Kulup getKulup(int kulupId) {
		
		return kulupActivityDAO.getKulup(kulupId);
	}

	@Override
	public void deleteKulup(int kulupId) {
		
		kulupActivityDAO.deleteKulup(kulupId);
		
	}

}
