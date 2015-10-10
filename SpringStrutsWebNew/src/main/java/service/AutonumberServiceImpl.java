package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.AutonumberDao;
import domain.Autonumber;

@Component
public class AutonumberServiceImpl implements AutonumberService{

	@Autowired
	AutonumberDao dao;
	
	public Autonumber getNextValue( String key)
	{
		return dao.getNextValue(key);
	}
}
