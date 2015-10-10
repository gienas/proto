package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domain.Autonumber;

@Repository
public class AutonumberDaoImpl implements AutonumberDao {

	@PersistenceContext()
	private EntityManager em;

	@Transactional
	public Autonumber getNextValue(String key) {
		List<Autonumber> list =  em.createQuery("from Autonumber as a where a.key=:key")
				.setParameter("key", key)
				.setLockMode(LockModeType.PESSIMISTIC_WRITE)
				.getResultList();
		Autonumber a;
		
		if ( list.size() == 0)
		{
			a = new Autonumber();
			a.setKey(key);
			a.setValue("1");
			em.persist(a);
		}	
		else
		{
			a = list.get(0);
			Integer value = Integer.parseInt(a.getValue()); 
			value++;
			a.setValue(value.toString());
		}

		//em.lock(a, LockModeType.PESSIMISTIC_READ);
		return a;
	}
}
