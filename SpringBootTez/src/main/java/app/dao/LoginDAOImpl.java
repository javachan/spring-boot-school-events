package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.domain.Konusmacim;
import app.domain.Login;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	private EntityManager entityManager;

	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}


	@Override
	public Login addLogin(Login login) {
		entityManager.getTransaction().begin();
		entityManager.persist(login);
		entityManager.getTransaction().commit();
		return login;
	}

	@Override
	public List<Login> getLogins() {
		TypedQuery<Login> query = entityManager.createQuery("Select e from Login e", Login.class);
		return query.getResultList();
	}

	@Override
	public List<Login> getLoginsById(int id) {
		TypedQuery<Login> query = entityManager.createQuery("Select e from Login e where e.id = :ID", Login.class)
				.setParameter("ID", id);
		return query.getResultList();
		
	}

	@Override
	public Login getLogin(int id) {
		
		return entityManager.find(Login.class, id);
	}

	@Override
	public Login deleteLogin(int id) {
	
		Login login = getLogin(id);
		
		if(login != null){
			entityManager.getTransaction().begin();
			entityManager.remove(login);
			entityManager.getTransaction().commit();
		}
		
		return login;
	}

}
