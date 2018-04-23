package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import app.dao.BaskanActivityDAO;
import app.domain.Baskan;


@Service("baskanService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BaskanActivityServiceImpl implements BaskanActivityService {

	@Autowired
	private BaskanActivityDAO baskanActivityDAO;
	
	 @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Baskan addBaskan(Baskan baskan) {
		
		return baskanActivityDAO.addBaskan(baskan);
		
	}

	
	@Override
	public List<Baskan> getBaskanlar() {
		
		return baskanActivityDAO.getBaskanlar();
	}

	@Override
	public Baskan getBaskan(int baskanId) {
		
		return baskanActivityDAO.getBaskan(baskanId);
	}

	@Override
	public void deleteBaskan(int baskanId) {
		
		baskanActivityDAO.deleteBaskan(baskanId);
		
	}



}
