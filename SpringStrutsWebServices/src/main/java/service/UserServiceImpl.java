package service;

import java.util.List;
import java.util.Random;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import security.MyUserDetails;

import dao.UserDao;
import domain.User;
//@Aspect
@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	@Override
	//@Pointcut("execution(* getAll*())")
	public List<User> getAll() {
		// TODO Auto-generated method stub
		System.out.println("getAll");
		return userDao.getAll();
	}

	@Override
	@Transactional
	public void saveOrUpdate(User u) {
		
		Random generator = new Random();
		System.out.println("ID = " + u.getId());
		if (u.getId() == null || u.getId() == 0 ) {
			System.out.println("zapis");
			u.setId(generator.nextInt());
			userDao.persist(u);
		}
		else
		{
			System.out.println("aktualizacja");
			userDao.update(u);
		}	
	}

	@Override
	public User get(User u) {
		// TODO Auto-generated method stub
		return userDao.get(u.getId());
	}

	//Na potrzeby bezpieki
	public MyUserDetails find( String email, String password )
	{
		User user =  userDao.find(email, password);
		return user != null ? new MyUserDetails(user) :null;
	}
	
	
	@Override
	@Transactional
	public void delete(User u) {
		userDao.delete( u );
	}

}
