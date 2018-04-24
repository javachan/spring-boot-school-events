package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Baskan;
import app.domain.Konusmaci;

@Repository
public class KonusmaciDAOImpl implements KonusmaciDAO {
	
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Konusmaci addKonusmaci(Konusmaci konusmaci) {
		entityManager.getTransaction().begin();
		entityManager.persist(konusmaci);
		entityManager.getTransaction().commit();
		return konusmaci;
	}

	@Override
	public List<Konusmaci> getKonusmacilar() {
		TypedQuery<Konusmaci> query = entityManager.createQuery("Select e from Konusmaci e", Konusmaci.class);
		return query.getResultList();
	}

	@Override
	public Konusmaci getKonusmaci(int konusmaciId) {
		
		return entityManager.find(Konusmaci.class, konusmaciId);
	}

	@Override
	public void deleteKonusmaci(int konusmaciId) {
	
		Konusmaci konusmaci = getKonusmaci(konusmaciId);
		
		if(konusmaci != null){
			
			entityManager.getTransaction().begin();
			entityManager.remove(konusmaci);
			entityManager.getTransaction().commit();
		}
		
	}

	
}
