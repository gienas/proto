package dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import domain.User;

public interface UserDao {

	public List<User> getAll() throws DataAccessException;
	public void persist( User u);
	public User get( Serializable id) throws DataAccessException;
	public void delete( User u);
	public void update( User u);
	public User find( String email, String password ) throws DataAccessException;
}
