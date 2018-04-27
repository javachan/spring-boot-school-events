package app.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Basvuru;


@Repository
public class BasvuruDAOImpl implements BasvuruDAO{

	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	
	@Override
	public Basvuru addBasvuru(Basvuru basvuru) {
	
		entityManager.getTransaction().begin();
		entityManager.persist(basvuru);
		entityManager.getTransaction().commit();
		
		return basvuru;
	}

	@Override
	public List<Basvuru> getBasvurular() {
		TypedQuery<Basvuru> query = entityManager.createQuery("Select e from Basvuru e", Basvuru.class);
		return query.getResultList();
	}

	@Override
	public List<Basvuru> getBasvurularById(int bId) {
		TypedQuery<Basvuru> query = entityManager.createQuery("Select e from Basvuru e where e.bId = :ID", Basvuru.class)
				.setParameter("ID", bId);
		return query.getResultList();
	}

	@Override
	public Basvuru getBasvuru(int bId) {
		
		return entityManager.find(Basvuru.class, bId);
	}

	@Override
	public Basvuru deleteBasvuru(int bId) {
		Basvuru basvuru = getBasvuru(bId);
		if(basvuru != null){
			entityManager.getTransaction().begin();
			entityManager.remove(basvuru);
			entityManager.getTransaction().commit();
		}
		return basvuru;
	}

}
