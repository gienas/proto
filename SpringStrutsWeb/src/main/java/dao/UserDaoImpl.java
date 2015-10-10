package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext()
	private EntityManager em;

	@Override
	public List<User> getAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return em.createQuery("from User").getResultList();
	}

	
	/**
	 * 
	 */
	@Override
	public void persist(User u) {
		// TODO Auto-generated method stub
		em.persist(u);
	}

	/**
	 * 
	 */
	@Override
	public User get(Serializable id) throws DataAccessException {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
		
	}

	/**
	 * 
	 */
	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		em.remove(get(u.getId()));
	}


	@Override
	public void update(User u) {
		em.merge(u);
		
	}


	@Override
	public User find(String email, String password) throws DataAccessException {
		// TODO Auto-generated method stub
		
		List<User> list =  em.createQuery("from User u where u.email=:email and u.password=:pass")
		.setParameter("email", email)
		.setParameter("pass", password)
		.getResultList();
		return list.size() >= 1 ? list.get(0) : null;
	}
	
}
