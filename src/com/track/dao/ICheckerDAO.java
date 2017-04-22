package com.track.dao;

import java.util.List;

import com.track.entity.Checker;

public interface ICheckerDAO {
	public List<Checker> getChecker();
	public void addChecker(Checker checker );
	public void deleteChecker(Checker checker );	
}
