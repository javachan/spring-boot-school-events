package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Baskan;
import app.domain.Etkinlik;
import app.domain.Konusmacim;

@Repository
public class KonusmaciDAOImpl implements KonusmaciDAO {
	
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Konusmacim addKonusmaci(Konusmacim konusmacim) {
		entityManager.getTransaction().begin();
		entityManager.persist(konusmacim);
		entityManager.getTransaction().commit();
		return konusmacim;
	}

	@Override
	public List<Konusmacim> getKonusmacilar() {
		TypedQuery<Konusmacim> query = entityManager.createQuery("Select e from Konusmacim e", Konusmacim.class);
		return query.getResultList();
	}

	@Override
	public Konusmacim getKonusmaci(int konusmaciId) {
		
		return entityManager.find(Konusmacim.class, konusmaciId);
	}

	@Override
	public void deleteKonusmaci(int konusmaciId) {
	
		Konusmacim konusmacim = getKonusmaci(konusmaciId);
		
		if(konusmacim != null){
			
			entityManager.getTransaction().begin();
			entityManager.remove(konusmacim);
			entityManager.getTransaction().commit();
		}
		
	}

	@Override
	public List<Konusmacim> getKonusmaciById(int konusmaciId) {
		TypedQuery<Konusmacim> query = entityManager.createQuery("Select e from Konusmacim e where e.konusmaciId = :ID", Konusmacim.class)
				.setParameter("ID", konusmaciId);
		return query.getResultList();
	}

	
}
