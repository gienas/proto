package dao;

import org.springframework.stereotype.Repository;

import domain.Autonumber;

@Repository
public interface AutonumberDao {

	
	
	public Autonumber getNextValue( String key);


}
