package com.track.dao;

import java.util.List;

import com.track.entity.Place;

public interface IPlaceDAO {
	public void addPlace(Place pl );
	public void updatePlace(Place pl);
	public void deletePlace(Place pl );
	public  List<Place> getPlaceByUid(int uid,int size,int pageNo);
	public int getPlaceTotalByUid(int uid);
	public Place getPlaceByID(int id );
	public  List<Place> getPlaceByState(int state,int size,int pageNo);
	public int getPlaceTotalByState(int state);
	public  List<Place> getAllPlaceByUid(int uid);
}
