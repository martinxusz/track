package com.track.dao;

import java.util.List;

import com.track.entity.Law;

public interface ILawDAO {
	public List<Law> getLaw(int size,int pageNo);
	public int getLawTotal();
	public void updateLaw(Law law);
	public Law getLawById(int id);
	public void addLaw(Law law );
	public void deleteLaw(Law law );
}
