package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Etkinlik;
import app.domain.Konusmaci;

@Repository
public class EtkinlikDAOImpl implements EtkinlikDAO {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public Etkinlik addEtkinlik(Etkinlik etkinlik) {
	
		entityManager.getTransaction().begin();
		entityManager.persist(etkinlik);
		entityManager.getTransaction().commit();
		return etkinlik;
	}

	@Override
	public List<Etkinlik> getEtkinlikler() {
		TypedQuery<Etkinlik> query = entityManager.createQuery("Select e from Etkinlik e", Etkinlik.class);
		return query.getResultList();
	}

	@Override
	public Etkinlik getEtkinlik(int id) {
		return entityManager.find(Etkinlik.class, id);
	}

	@Override
	public void deleteEtkinlik(int id) {
		
		Etkinlik etkinlik = getEtkinlik(id);
		
		if(etkinlik != null){
			entityManager.getTransaction().begin();
			entityManager.remove(etkinlik);
			entityManager.getTransaction().commit();
		}
		
	}

	@Override
	public List<Etkinlik> getEtkinlikById(int id) {
		TypedQuery<Etkinlik> query = entityManager.createQuery("Select e from Etkinlik e where e.id = :ID", Etkinlik.class)
			.setParameter("ID", id);
	return query.getResultList();
	}

}
