package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Baskan;
import app.domain.Kulup;


@Repository
public class BaskanActivityDAOImpl implements BaskanActivityDAO{
	
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}
	@Override
	public Baskan addBaskan(Baskan baskan) {
		entityManager.getTransaction().begin();
		entityManager.persist(baskan);
		entityManager.getTransaction().commit();
		return baskan;
	}

	@Override
	public List<Baskan> getBaskanlar() {
		//TypedQuery<Baskan> query = sessionFactory.getCurrentSession().createQuery("Select e from Baskan e",Baskan.class);
		//return query.getResultList();
		TypedQuery<Baskan> query = entityManager.createQuery("Select e from Baskan e", Baskan.class);
		return query.getResultList();
		//return (List<Baskan>)sessionFactory.getCurrentSession().createQuery("Select e from Baskan e",Baskan.class).getResultList();
	}

	@Override
	public Baskan getBaskan(int baskanId) {
	
		return entityManager.find(Baskan.class, baskanId);
	}

	@Override
	public void deleteBaskan(int baskanId) {
		/*
		 * Baskan baskan = getBaskan(baskanId);
		 
		if(baskan != null){
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().remove(baskan);
			sessionFactory.getCurrentSession().getTransaction().commit();
		}*/
		
		//sessionFactory.getCurrentSession().getTransaction().begin();
		//sessionFactory.getCurrentSession().createQuery("Delete from Baskan b where b.baskanId = :ID").setParameter("ID", baskanId).executeUpdate();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		 Baskan baskan = getBaskan(baskanId);
		    if(baskan != null){
				entityManager.getTransaction().begin();
				entityManager.remove(baskan);
				entityManager.getTransaction().commit();
		    }
	}
	
	

}
