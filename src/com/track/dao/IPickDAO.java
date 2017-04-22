package com.track.dao;

import java.util.List;

import com.track.entity.Pick;
import com.track.entity.Place;
import com.track.entity.Produce;

public interface IPickDAO {
	public void addPick(Pick pl );
	public void updatePick(Pick pl);
	public Pick getPickByID(int id );
	public int getPickTotalByUid(int uid);
	public  List<Pick> getPickByUid(int uid,int size,int pageNo);
}
