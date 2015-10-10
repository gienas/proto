package service;

import domain.Autonumber;

public interface AutonumberService {

	public Autonumber getNextValue( String key);
}
