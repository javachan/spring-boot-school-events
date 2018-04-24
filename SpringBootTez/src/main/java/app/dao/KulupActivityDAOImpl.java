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
public class KulupActivityDAOImpl implements KulupActivityDAO {

	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	@Override
	public Kulup addKulup(Kulup kulup) {
	
		//sessionFactory.getCurrentSession().saveOrUpdate(kulup);	
		
			entityManager.getTransaction().begin();
		    entityManager.persist(kulup);
			entityManager.getTransaction().commit();
			
			return kulup;
	}


	@Override
	public List<Kulup> getKulupler() {
		
		//TypedQuery<Kulup> query = sessionFactory.getCurrentSession().createQuery("Select e from Kulup e",Kulup.class);
		//return query.getResultList();
		TypedQuery<Kulup> query = entityManager.createQuery("Select e from Kulup e", Kulup.class);
		return query.getResultList();
		//return (List<Kulup>)sessionFactory.getCurrentSession().createQuery("Select e from Kulup e",Kulup.class).getResultList();
	}

	@Override
	public Kulup getKulup(int kulupId) {

		return entityManager.find(Kulup.class, kulupId);
	}

	@Override
	public void deleteKulup(int kulupId) {
		/*
		Kulup kulup = getKulup(kulupId);
		if(kulup != null){
			sessionFactory.getCurrentSession().getTransaction().begin();
			sessionFactory.getCurrentSession().delete(kulup);
			sessionFactory.getCurrentSession().getTransaction().commit();
		}
		*/
		//TypedQuery<Kulup> query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Kulup WHERE id ="+kulupId,Kulup.class);
		
		//query.executeUpdate();	
		//sessionFactory.getCurrentSession().getTransaction().begin();
		//sessionFactory.getCurrentSession().createQuery("Delete from Kulup k where k.kulupId = :ID").setParameter("ID", kulupId).executeUpdate();
		//sessionFactory.getCurrentSession().getTransaction().commit();
		/*
		sessionFactory.getCurrentSession().getTransaction().begin();
		org.hibernate.query.Query<Kulup> query = sessionFactory.getCurrentSession().createQuery("Delete from Kulup k where k.id = :id",Kulup.class);
		query.setParameter("id", kulupId);
		query.executeUpdate();
		sessionFactory.getCurrentSession().getTransaction().commit();
		*/
		/*
		 Session session ;
		    Kulup kulup ;

		    session = sessionFactory.getCurrentSession();
		    kulup = (Kulup)session.load(Kulup.class,kulupId);
		    session.delete(kulup);
		    //This makes the pending delete to be done
		    */
		
		/*org.hibernate.query.Query query= sessionFactory.getCurrentSession().createQuery("Delete from Kulup k where k.id = :id");
	       query.setParameter("id", kulupId);
	       query.executeUpdate();
	       */
		Kulup kulup = getKulup(kulupId);
		if(kulup != null){
			entityManager.getTransaction().begin();
			entityManager.remove(kulup);
			entityManager.getTransaction().commit();
	    }
		

	}

	//@Override
	//public List<Kulup> getKuluplerById(int kulupId) {
		//TypedQuery<Kulup> query = entityManager.createQuery("Select e from Kulup e where e.kulupId = :ID", Kulup.class)
			//	.setParameter("ID", kulupId);
		//return query.getResultList();
	//}
	

}
